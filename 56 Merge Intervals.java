class Solution {
    public int[][] merge(int[][] intervals) {
        int[] dp = new int[10001]; 
        int[] single = new int[10001];
        for (int[] pair : intervals) {
            if (pair[0] == pair[1]) {
                single[pair[0]] = 1;
            } else {
                dp[pair[0]]++;
                dp[pair[1]]--;
            }
        } 


        List<int[]> list = new ArrayList<>();
        int sum = 0;
        int index = 0;

        while (index < 10001) {
            sum = sum + dp[index];
            if (sum > 0) {
                int start = index;
                index++;
                while (sum > 0) {
                    sum = sum + dp[index];
                    index++;
                }
                int[] node = new int[] {start, index - 1};
                list.add(node);
            } else if (single[index] == 1) {
                int[] node = new int[] {index, index};
                list.add(node);
                index++;
            } else {
                index++;
            }
        }
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i)[0];
            result[i][1] = list.get(i)[1];
        }
        return result;

    }
}