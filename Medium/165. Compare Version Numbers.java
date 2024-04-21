class Solution {
    public int compareVersion(String version1, String version2) {
        int one = 0;
        int two = 0;
        while (one < version1.length() || two < version2.length()) {
            int sum1 = 0;
            int sum2 = 0;
            while (one < version1.length() && version1.charAt(one) != '.') {
                sum1 = sum1 * 10 + version1.charAt(one) - '0';
                one++;
            }
            if (one < version1.length() && version1.charAt(one) == '.') {
                one++;
            }
            while (two < version2.length() && version2.charAt(two) != '.') {
                sum2 = sum2 * 10 + version2.charAt(two) - '0';
                two++;
            }
            if (two < version2.length() && version2.charAt(two) == '.') {
                two++;
            }
            if (sum1 > sum2) {
                return 1;
            } else if (sum1 < sum2) {
                return -1;
            }
        }
        return 0;
        
    }
}