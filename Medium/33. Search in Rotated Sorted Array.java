class Solution {
    public int search(int[] nums, int target) {
        // corner case
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int midIndex = findMid(nums); // the last one of the left array;
        if (nums[0] <= target && nums[midIndex] >= target) {
            return findTarget(nums, 0, midIndex, target);
        }
        if (midIndex + 1 < nums.length && nums[midIndex + 1] <= target && nums[nums.length - 1] >= target) {
            return findTarget(nums, midIndex + 1, nums.length - 1, target);
        }
        return -1;
    }

    private int findTarget(int[] array, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid; 
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int findMid(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] > nums[0]) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (nums[left] >= nums[right]) {
            return left;
        }
        return right;
    }
}