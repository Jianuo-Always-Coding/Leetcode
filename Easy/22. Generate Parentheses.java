class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(result, sb, 0, 0, n);
        return result;
    }

    private void helper(List<String> result, StringBuilder sb, int leftAdd, int rightAdd, int n) {
        // base case
        if (leftAdd == n && rightAdd == n) {
            result.add(sb.toString());
            return ;
        }
        if (leftAdd < n) {
            sb.append('(');
            helper(result, sb, leftAdd + 1, rightAdd, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (rightAdd < leftAdd && rightAdd < n) {
            sb.append(')');
            helper(result, sb, leftAdd, rightAdd + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}