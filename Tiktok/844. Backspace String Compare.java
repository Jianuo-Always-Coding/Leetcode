class Solution {
    public boolean backspaceCompare(String s, String t) {
        // corner case
        if (s == null && t == null || s.length() == 0 && t.length() == 0) {
            return true;
        }

        // 判断第一个字符串中剩余的字符
        int firstLeft = 0;
        char[] first = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '#') {
                first[firstLeft++] = c;
            } else {
                firstLeft = Math.max(0, firstLeft - 1);
            }
        }

        // 判断第二个字符串中剩余的字符
        int secondLeft = 0;
        char[] second = t.toCharArray();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (c != '#') {
                second[secondLeft++] = c;
            } else {
                secondLeft = Math.max(0, secondLeft - 1);
            }
        }
        // 回退一个开始比较
        secondLeft--;
        firstLeft--;
        while (secondLeft >= 0 && firstLeft >= 0) {
            if (first[firstLeft] != second[secondLeft]) {
                return false;
            }
            firstLeft--;
            secondLeft--;
        }
        
        // 其中一个有剩余也不行
        return firstLeft == secondLeft;
    }
}
