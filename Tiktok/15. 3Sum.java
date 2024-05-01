class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // 移动直到不同，不希望收集到重复的解
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int target = -nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end];
                if (sum == target) {
                    List<Integer> sol = new ArrayList<>();
                    sol.add(nums[i]);
                    sol.add(nums[start]);
                    sol.add(nums[end]);
                    res.add(sol);
                    start++;
                    end--;
                    // 移动左直到不同，左一旦不同，右面一定不满足，所以一定会移动
                    while (start < end && nums[start] == nums[start - 1]) {
                        start++;
                    }
                } else if (sum > target) {
                    end--;
                } else {
                    start++;
                }
            }
            
        }
        return res;
    }
}