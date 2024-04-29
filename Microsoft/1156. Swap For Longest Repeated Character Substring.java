class Solution {
    public int maxRepOpt1(String text) {
        // 创建一个长度为26的整型数组，用于记录每个小写字母在text中出现的频率
        int[] freq = new int[26];
        // 统计text中每个小写字母的出现频率
        for (char c: text.toCharArray()) {
            freq[c - 'a']++;
        }
        // 初始化最大连续重复字符子串的长度为1
        int maxLen = 1;
        // 获取text的长度
        int n = text.length();
        // 遍历text中的每个字符
        for (int i = 0; i < text.length();) {
            // 获取当前字符
            char cur = text.charAt(i);
            // 初始化当前字符所在的连续重复字符子串长度为1
            int segmentLen = 1;
            // 初始化指针j指向当前字符的下一个字符
            int j = i + 1;
            // 计算当前字符连续重复的长度
            while (j < n && text.charAt(j) == cur) {
                j++;
                segmentLen++;
            }
            // 记录第一个不同于当前字符的字符的索引
            int diffCharIdx = j;
            // 继续向后遍历，直到遇到下一个不同于当前字符的字符
            j++;
            while (j < n && text.charAt(j) == cur) {
                j++;
                segmentLen++;
            }
            // 更新连续重复字符子串的长度，考虑是否能够插入一个额外的相同字符
            segmentLen = Math.min(segmentLen + 1, freq[cur - 'a']);
            // 更新最大连续重复字符子串的长度
            maxLen = Math.max(segmentLen, maxLen);
            // 更新i，准备处理下一个不同于当前字符的字符
            i = diffCharIdx;
        }
        // 返回最大连续重复字符子串的长度
        return maxLen;
    }
}
