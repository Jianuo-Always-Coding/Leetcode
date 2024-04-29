class Solution {
    public int minTransfers(int[][] transactions) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int[] transaction : transactions){
            int from = transaction[0];
            int to = transaction[1];
            int value = transaction[2];
            map.put(from, map.getOrDefault(from, 0) - value);
            map.put(to, map.getOrDefault(to, 0) + value);
        }
        int[] balance = new int[map.size()];
        int index = 0;
        for(int key : map.keySet()){
            balance[index++] = map.get(key);
        }
        return backtracking(balance, 0);
    }
    public int backtracking(int[] balance, int start){
        if(start == balance.length){
            return 0;
        }
        if(balance[start] == 0){
            return backtracking(balance, start + 1);
        }
        int res = Integer.MAX_VALUE;
        int amount = balance[start];
        for(int i = start + 1; i < balance.length; i++){
            if(balance[i] * balance[start] >= 0){
                continue;
            }
            balance[i] += amount;
            res = Math.min(res, backtracking(balance, start + 1) + 1);
            balance[i] -= amount;
        }
        return res;
    }
}