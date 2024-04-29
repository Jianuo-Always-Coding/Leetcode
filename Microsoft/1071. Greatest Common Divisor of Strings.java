class Solution {
    // 寻找两个字符串的最大公约字符串
    public String gcdOfStrings(String str1, String str2) {
        String shortStr;
        // 将较短的字符串作为短字符串
        if (str1.length() > str2.length()) {
            shortStr = str2;
        } else {
            shortStr = str1;
        }
        
        // 从短字符串的长度开始向下搜索可能的最大公约字符串
        for (int i = shortStr.length(); i > 0; i--) {
            String prefix = shortStr.substring(0, i); // 截取前缀
            // 如果该前缀能够同时整除str1和str2，则返回该前缀
            if (isDivisor(prefix, str1) && isDivisor(prefix, str2))
                return prefix;
        }
        return ""; // 未找到符合条件的最大公约字符串，返回空字符串
    }

    // 判断前缀是否能整除字符串
    private boolean isDivisor(String prefix, String fullString) {
        // 使用循环判断字符串是否以前缀开始，如果是，则继续截取前缀之后的字符串
        while (fullString.startsWith(prefix)) {
            fullString = fullString.substring(prefix.length());
            // 如果截取后的字符串为空，则说明前缀能够整除原字符串
            if (fullString.equals("")) {
                return true;
            }
        }
        return false; // 未能整除，则返回false
    }
}