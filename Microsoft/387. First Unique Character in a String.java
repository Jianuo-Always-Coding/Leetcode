class Solution {
    public int firstUniqChar(String s) {
        // 创建哈希表用于存储字符和出现次数
        Map<Character, Integer> countMap = new HashMap<>();
        
        // 第一次遍历字符串，记录每个字符出现的次数
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        
        // 第二次遍历字符串，找到第一个出现次数为 1 的字符并返回其索引
        for (int i = 0; i < s.length(); i++) {
            if (countMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        
        // 如果没有找到出现次数为 1 的字符，则返回 -1
        return -1;
    }
}