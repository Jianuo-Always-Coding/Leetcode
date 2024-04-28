public class Solution {
    public boolean checkValidString(String s) {
        // 可以包含的左括号的最小和最大数量
        int leftMin = 0, leftMax = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftMin++;
                leftMax++;
            } else if (c == ')') {
                leftMin--;
                leftMax--;
            } else {
                leftMin--;
                leftMax++;
            }
            if (leftMax < 0) return false;
            if (leftMin < 0) leftMin = 0;
        }
        // 判断是否匹配完
        return leftMin == 0;
    }
}