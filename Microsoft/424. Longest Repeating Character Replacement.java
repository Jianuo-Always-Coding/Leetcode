class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int length = 0;
        int max = 0; // 用于记录当前窗口内出现次数最多的字母的出现次数
        int l = 0;
        int r = 0;
        while (r < s.length()) {
            count[s.charAt(r) - 'A']++;
            max = Math.max(max, count[s.charAt(r) - 'A']);
            if (r - l + 1 - max > k) { // 需要更改的字母大于k
                // 移动左边界
                count[s.charAt(l) - 'A']--;
                l++;
            }
            // 更新，移动右面边界
            length = Math.max(length, r - l + 1);
            r++;
        }
        return length;
    }
}