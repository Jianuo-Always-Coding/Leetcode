class Solution {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        int index = 0;
        int res = 0;
        while (index < chars.length) {
            char ch = chars[index];
            int count = 0;
            while (index < chars.length && chars[index] == ch) {
                count++;
                index++;
            }
            chars[res++] = ch;
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[res++] = c;
                }
            }
        }
        return res;

        
    }
}