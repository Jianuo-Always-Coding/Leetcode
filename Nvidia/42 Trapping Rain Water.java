class Solution {
    public int trap(int[] height) {
        // corner case
        if (height == null || height.length <= 2) {
            return 0;
        }
        int left = 0;
        int leftMax = height[0];
        int right = height.length - 1;
        int rightMax = height[height.length - 1];
        int count = 0;
        if (leftMax <= rightMax) {
            left++;
        } else {
            right--;
        }

        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    count += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    count += rightMax - height[right];
                }
                right--;
            }
        }
        return count;
    }
}