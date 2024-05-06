class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            // 找到了
            if (nums[mid] == target) {
                return mid;
            }

            // left和mid在同一段
            if (nums[left] <= nums[mid]) {
                /**
                if (nums[left] < target && nums[mid] < target) {
                    left = mid + 1;
                }  else if (nums[left] < target && nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[left] == target && nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[left] == target && nums[mid] < target) {
                    // 不可能
                } else if (nums[left] > target && nums[mid] < target) {
                    // 不可能
                } else if (nums[left] > target && nums[mid] > target) {
                    left = mid + 1;
                }

                */
                
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            // left 和 mid 不在同一段，left和right在同一段
            } else {
                /**
                if (nums[right] < target && nums[mid] < target) {
                    right = mid - 1;
                }  else if (nums[right] < target && nums[mid] > target) {
                    // 不存在
                } else if (nums[right] == target && nums[mid] > target) {
                    // 不存在
                } else if (nums[right] == target && nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[right] > target && nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[right] > target && nums[mid] > target) {
                    right = mid - 1;
                }

                */
                if (nums[right] >= target && nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
