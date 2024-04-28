class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int maxProduct = nums[0];
        int minProduct = nums[0]; // 可能存在负数的情况，所以在这里存放一个最小的
        int result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int tempMax = maxProduct;
            int tempMin = minProduct;
            
            maxProduct = Math.max(nums[i], Math.max(tempMax * nums[i], tempMin * nums[i]));
            minProduct = Math.min(nums[i], Math.min(tempMax * nums[i], tempMin * nums[i]));
            
            result = Math.max(result, maxProduct);
        }
        
        return result;
    }
}