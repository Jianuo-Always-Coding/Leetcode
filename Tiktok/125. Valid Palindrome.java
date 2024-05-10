class Solution {
    public boolean isPalindrome(String s) {
        String text = s.toLowerCase();
        // System.out.println(text);
        int left = 0; 
        int right = s.length() - 1;
        while (left < right) {
            char c = text.charAt(left);
            while (left < right && !Character.isLetterOrDigit(text.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(text.charAt(right))) {
                right--;
            }
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
