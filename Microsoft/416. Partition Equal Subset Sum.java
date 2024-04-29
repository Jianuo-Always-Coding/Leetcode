class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum += nums[i];
        }
        if(sum % 2 != 0) return false;
        int half = sum/2;
        boolean[] dp = new boolean[half+1];
        dp[0] = true;
        for(int cur : nums){
            for(int j = half; j >= cur; j--){
                dp[j] = (dp[j] || dp[j-cur]); // 如果原来到过这里，或者加上cur能到达这里
            }
        }
        return dp[half];
    }
}

/**
时间复杂度分析：
外层循环遍历了整个数组 nums，所以它的时间复杂度是 O(n)，其中 n 是数组 nums 的长度。
内层循环的时间复杂度取决于 half，即数组元素和的一半。内层循环的执行次数取决于 half，因此内层循环的时间复杂度是 O(half)。
综合起来，整段代码的时间复杂度是 O(n * half)，其中 n 是数组 nums 的长度，half 是数组元素和的一半。
空间复杂度分析：
我们使用了一个大小为 half + 1 的布尔数组 dp，所以它的空间复杂度是 O(half)。
除了 dp 数组之外，我们只使用了几个额外的变量，它们的空间占用很小，可以忽略不计。
综合起来，整段代码的空间复杂度是 O(half)。
 */
