class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new LinkedList<>();
        for (int num : nums) {
            // 注意索引，元素大小从 1 开始，有一位索引偏移
            if (nums[Math.abs(num) - 1] < 0) {
                // 之前已经把对应索引的元素变成负数了，
                // 这说明 num 重复出现了两次
                res.add(Math.abs(num));
            } else {
                // 把索引 num - 1 置为负数
                nums[Math.abs(num) - 1] *= -1;
            }
        }

        return res;
    }
}