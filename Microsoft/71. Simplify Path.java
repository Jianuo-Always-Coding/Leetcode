class Solution {
    public String simplifyPath(String path) {
        String[] splits = path.split("/");
        List<String> res = new ArrayList<>();
        for (int i = 0; i < splits.length; i++) {
            String curr = splits[i];
            if (curr.length() == 0 || curr.equals(".")) {
                // 一个点指当前路径忽略
                continue;
            }
            if (curr.equals("..")) {
                // 两个点 返回上一级
                if (res.size() > 0) {
                    res.remove(res.size() - 1);
                }
            } else {
                // 否则作为一个字路径
                res.add(curr);
            }
        }
        // 统计结果
        String ans = "";
        for (int i = 0; i < res.size(); i++) {
            ans += "/";
            ans += res.get(i);
        }
        if (ans.length() == 0) {
            return "/";
        }
        return ans;
    }
}
