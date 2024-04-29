public class Solution {
    // 使用prefix sum的思想
    public int subarraySum(int[] nums, int k) {
        // 记录满足条件的子数组数量
        int count = 0;
        // 记录当前累加和
        int sum = 0;
        // 使用哈希表存储累加和及其出现的次数，键为累加和，值为出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        // 空数组的累加和为0，出现的次数为1
        map.put(0, 1);
      
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 更新当前累加和
            sum += nums[i];
            // 判断是否存在前缀和等于 sum - k 的子数组，若存在，更新 count
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            // 更新哈希表中当前累加和的出现次数
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        // 返回满足条件的子数组数量
        return count;
    }
}