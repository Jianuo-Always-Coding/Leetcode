class Solution {
    public int search(int[] nums, int target) {
        // Assumpt : no duplicate numbers
        // corner case
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int lastMaxIndex = findLastMaxIndex(nums);
        int r1 = findTarget(nums, 0, lastMaxIndex, target);
        if (r1 != -1) {
            return r1;
        }
        return findTarget(nums, lastMaxIndex + 1, nums.length - 1, target);
    }

    private int findLastMaxIndex(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[left] < array[mid]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (array[left] < array[right]) {
            return right;
        }
        return left;
    }

    private int findTarget(int[] array, int left, int right, int target) {
        // corner case
        if (left > right) {
            return -1;
        }

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
}