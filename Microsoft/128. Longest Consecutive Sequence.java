class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            // 找到最左面的
            if (!set.contains(nums[i] - 1)) {
                int right = nums[i] + 1;
                int count = 1;
                while (set.contains(right)) {
                    right++;
                }
                max = Math.max(max, right - nums[i]);
            }
        }
        return max;
    }


}