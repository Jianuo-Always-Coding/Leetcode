class Solution {
    public String largestPalindromic(String num) {
        int[] count = new int[10]; // 保存每个数字的出现次数
        char oddLetter = ' ';

        // 统计每个数字的出现次数
        for (char c : num.toCharArray()) {
            int digit = c - '0';
            count[digit]++;
        }

        // 构造回文数的左半部分
        StringBuilder leftHalf = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            // 对于首次出现次数为奇数的数字，记录
            if (count[i] % 2 != 0 && oddLetter == ' ') {
                oddLetter = (char) ('0' + i);
                count[i]--;
            }
            // 对于出现次数为偶数的数字，将其一半添加到左半部分
            for (int j = 0; j < count[i] / 2; j++) {
                leftHalf.append(i);
            }
        }

        // 构造完整的回文数
        StringBuilder palindrome = new StringBuilder(leftHalf);
        // 如果中间有数字加入
        if (oddLetter != ' ') {
            palindrome.append(oddLetter);
        }
        palindrome.append(leftHalf.reverse());

        // 处理特殊情况：去除头和尾的0
        String s = palindrome.toString();
        int left = 0;
        int right = s.length() - 1;
        while (left < s.length() - 1) {
            if (s.charAt(left) == '0') {
                left++;
            } else {
                break;

            }
        }
        while (right > 0) {
            if (s.charAt(right) == '0') {
                right--;
            } else {
                break;
            }
        }
        if (right < left) {
            return "0";
        }
        return s.substring(left, right + 1);

    }
}