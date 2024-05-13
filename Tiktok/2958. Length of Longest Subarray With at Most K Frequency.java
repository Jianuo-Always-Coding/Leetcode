class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0; // left指针

        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            // right指向的字符大于k的话，一直移除
            while (map.get(nums[right]) > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                left++;
            }
            // 更新结果
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
