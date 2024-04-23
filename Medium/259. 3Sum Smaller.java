class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) { 
                int sum = nums[left] + nums[right] + nums[i];
                if (sum < target) {
                    result = result + right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}