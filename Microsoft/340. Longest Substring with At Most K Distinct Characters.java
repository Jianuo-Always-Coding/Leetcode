class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // 创建一个Map用于存储字符及其出现的次数
        Map<Character, Integer> map = new HashMap<>();
        // 初始化结果变量
        int res = 0;
        // 初始化左指针位置
        int left = 0;
        // 遍历字符串
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 将当前字符加入到Map中，并更新其出现的次数
            map.put(c, map.getOrDefault(c, 0) + 1);
            // 如果Map中的不同字符数量大于k
            while (map.size() > k) {
                char d = s.charAt(left);
                // 将左指针对应的字符从Map中移除，并更新其出现的次数
                map.put(d, map.get(d) - 1);
                // 如果左指针对应的字符出现次数为0，则从Map中移除该字符
                if (map.get(d) == 0) map.remove(d);
                // 左指针右移
                left++;
            }
            // 更新结果为当前窗口的长度和之前结果的最大值
            res = Math.max(res, i - left + 1);
        }
        // 返回结果
        return res;
    }
}