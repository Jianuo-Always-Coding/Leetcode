class Solution {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return isPalindrome(s.substring(0, start) + s.substring(start + 1)) ||  isPalindrome(s.substring(0, end) + s.substring(end + 1));
            }
            start++;
            end--;
        }
        return true;
    }

    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
