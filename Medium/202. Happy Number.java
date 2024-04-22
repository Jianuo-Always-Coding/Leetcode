class Solution {
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        Set<Integer> set = new HashSet<>();

        while (true) {
            int prev = n;
            if (n == 1) {
                return true;
            }
            if (set.contains(n)) {
                return false;
            }

            int count = 0;
            while (n != 0) {
                count = count + (n % 10) * (n % 10);
                n = n / 10;
            }
            set.add(prev);
            n = count;
        }
    }
}
