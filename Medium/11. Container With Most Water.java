class Solution {
    public int maxArea(int[] height) {
        // corner case
        if (height == null || height.length <= 1) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int val = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, val);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}