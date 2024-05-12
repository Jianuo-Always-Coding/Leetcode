class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // 滑动窗口思想
        if(k <= 1) return 0;

        int prod = 1;
        int result = 0;

        int left = 0;
        int right = 0;

        while(right < nums.length){
            prod *= nums[right];

            // 乘积超界限了，移动左面
            while(prod >= k){
                prod /= nums[left];
                left++;
            }

            // 没超界限，加入结果然后移动右面
            result += right - left + 1;
            right++;
        }
        return result;
    }
}
