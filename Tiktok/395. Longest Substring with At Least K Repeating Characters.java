public class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        
        // corner case
        if (n==0 || n<k) return 0;
            
        // 记录当前字符串所有字母的出现次数
        int[] counts = new int[26];
        for (char c: s.toCharArray()) counts[c-'a']++;
        // boolean valid = true;
        char badchar = 0;
        for (int i=0; i<26; i++) {
            // 这里一定限制counts[i] > 0, 一定找到的是存在的字母
            if (counts[i]>0 && counts[i]<k) {
                badchar = (char)(i+'a');
                break;
            }
        }
        // 如果s满足条件，走完了所有for循环
        if (badchar==0) return n;

        // 以badchar作为分割
        String[] subs = s.split(badchar + "");
        int res = 0;
        for (String sub:subs) res = Math.max(res, longestSubstring(sub,k));
        return res;
    }
}
