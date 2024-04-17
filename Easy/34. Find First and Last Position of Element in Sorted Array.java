class Solution {
    public int[] searchRange(int[] nums, int target) {
        // corner case
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        int start = findFirst(nums, target);
        if (start == -1) {
            return new int[] {-1, -1};
        }
        int end = findLast(nums, target, start);
        return new int[] {start, end};
    }

    private int findFirst(int[] nums, int target) {
        int left = 0; 
        int right = nums.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }
        return -1;
    }

    private int findLast(int[] nums, int target, int left) {
        int right = nums.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if (nums[right] == target) {
            return right;
        } else if (nums[left] == target) {
            return left;
        }
        return -1;


    }
}