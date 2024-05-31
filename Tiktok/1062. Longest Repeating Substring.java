class Solution {
    public int longestRepeatingSubstring(String s) {
        int left = 1, n = s.length(), right = n;
        // 表示的是字符串的长度
        while(left<right){
            int mid = left + (right - left) / 2;
            if(search(mid, s)) left = mid + 1; // 有重复
            else right = mid;
        }
        return left-1;
    }
    private boolean search(int len, String s){
        // 从0开始长度为len的结果放入set中
        Set<Integer> set = new HashSet<>();
        // 从index为0开始便利
        for(int i = 0; i <= s.length()-len; i++){
            String key = s.substring(i, i+len);
            int code = key.hashCode();
            if(!set.add(code)) return true; // 找到重复
        }
        return false;
    }
}
