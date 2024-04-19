class Solution {
    public int trap(int[] height) {
        // corner case
        if (height == null || height.length <= 2) {
            return 0;
        }
        int sum = 0;
        int left = 0; 
        int right = height.length - 1;
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] < leftMax) {
                    sum = sum + leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
                left++;

            } else {
                if (height[right] < rightMax) {
                    sum = sum + rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
                right--;
            }
        }
        return sum;
    }
}