class Solution {
    public int pathSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // key : node represented by first 2 digits, val: value
        // 初始化所有的map
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int node = num / 10;
            int val = num % 10;
            map.put(node, val);
        }
        int root = nums[0] / 10;
        int[] result = new int[1];
        dfs(root, 0, map, result);
        return result[0]; 
    }

    private void dfs(int node, int sum, Map<Integer, Integer> map, int[] result) {
        if (!map.containsKey(node)) {
            return;
        }
        sum += map.get(node);
        int depth = node / 10;
        int possition = node % 10;
        // 求出左右孩子position的匹配模式
        int left = (depth + 1) * 10 + possition * 2 - 1;
        int right = left + 1;
        // 说明是root
        if (!map.containsKey(left) && !map.containsKey(right)) {
            result[0] += sum;
            return;
        } else {
            dfs(left, sum, map, result);
            dfs(right, sum, map, result);
        }
    }
}
