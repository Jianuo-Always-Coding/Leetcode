class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        dfs(s, res, new StringBuilder(), 0, 0);
        return res;
    }

    private void dfs(String s, List<String> res, StringBuilder sb, int start, int level) {
        if (start == s.length() && level == 4) {
            res.add(sb.toString());
            return;
        }
        if (start > s.length() || level > 4) {
            return;
        }
        
        int len = sb.length();
        for (int i = 1; i <= 3; i++) {
            if (start + i > s.length()) {
                continue;
            }
            int num = Integer.valueOf(s.substring(start, start + i));
            if ((i == 1 && num >= 0 && num <= 9) || (i == 2 && num >= 10 && num <= 99) || (i == 3 && num >= 100 && num <= 255)) {
                sb.append(num);
                if (level < 3) {
                    sb.append('.');
                }
                dfs(s, res, sb, start + i, level + 1);
                sb.setLength(len);
            }
        }
    }
}