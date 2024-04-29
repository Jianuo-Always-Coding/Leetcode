class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        // 创建动态规划（DP）数组：我们创建了两个数组：
// dp：该数组存储以 nums 中每个元素结尾的最大可被整除的子集的大小。
// prev：该数组存储以 nums 中每个元素结尾的最大可被整除的子集中的前一个元素的索引。
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1); // 表示只有自己，所以size为1
        Arrays.fill(prev, -1); //表示索引为0
        
        int maxIndex = 0;
        
        // 动态规划方法：我们遍历 nums 中的每个元素，对于每个元素，我们遍历所有之前的元素。
        // 如果当前元素 nums[i] 可被之前的元素 nums[j] 整除，并且以 nums[j] 结尾的子集的大小加 1 大于以 nums[i] 结尾的当前子集的大小，我们更新 dp[i] 和 prev[i]。
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            // 寻找最大索引：在为所有元素更新 dp 和 prev 数组之后，我们找到 dp 数组中最大值的索引。该索引表示最大可被整除的子集的结尾。
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }
        // 重构子集：从上一步找到的最大索引开始，我们使用 prev 数组进行回溯并重构最大可被整除的子集。
        List<Integer> result = new ArrayList<>();
        int currIndex = maxIndex;
        while (currIndex != -1) {
            result.add(nums[currIndex]);
            currIndex = prev[currIndex];
        }
        
        return result;
    }
}