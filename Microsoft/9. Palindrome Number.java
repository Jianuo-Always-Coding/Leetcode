class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int sum = x;
        int val = 0;
        while (x != 0) {
            val = val * 10 + x % 10;
            x = x / 10;
        }
        if (val == sum) {
            return true;
        }
        return false;
    }
}