class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        // （a + b） % 60 == 0
        // a% 60 + b% 60 == 0;
        // a% 60 + b % 60 = 60;
        // key : remainder.  value :frequency
        int[] remainders = new int[60];
        int res = 0;
        for (int num : time) {
            int remainder = num % 60;
            if (remainder == 0) {
                res += remainders[0];
            } else {
                res += remainders[60 - remainder];
            }
            remainders[remainder]++;
        }
        return res;

        
    }
}


