class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;

        while (i < nums.length - 3) {
            int j = i + 1;
            while (j < nums.length - 2) {
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum = (long)nums[left] + nums[right] + nums[i] + nums[j];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left++], nums[right--]));
                        while (left < nums.length && nums[left] == nums[left-1]) {
                            left++;
                        }
                        while (right > left && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (nums[left] + nums[right] > target - nums[i] - nums[j]) {
                        right--;
                    } else {
                        left++;
                    }
                    
                }
                j++;
                while (j < nums.length - 2 && nums[j] == nums[j-1]) {
                    j++;
                }
            }
            i++;
            while (i < nums.length - 3 && nums[i] == nums[i-1]) {
                i++;
            }
        }
        return result;
    }
}