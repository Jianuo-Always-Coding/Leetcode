class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s == null || goal == null || s.length() != goal.length()) {
            return false;
        }
        List<Integer> diff = new ArrayList<>();
        Set<Character> set = new HashSet<>(); // (ab, ab) false / (aa, aa) true 必须交换一次
        boolean duplicate = false;
        for (int i = 0; i < s.length(); i++) {
            if (!set.add(s.charAt(i))) {
                duplicate = true;
            }
            if (s.charAt(i) != goal.charAt(i)) {
                diff.add(i);
            }
        }

        if (diff.size() == 0) {
            if (duplicate) {
                return true;
            }
            return false;
        } else if (diff.size() == 1) {
            return false;
        }
        if (diff.size() == 2 && s.charAt(diff.get(0)) == goal.charAt(diff.get(1))
                && s.charAt(diff.get(1)) == goal.charAt(diff.get(0))) {
            return true;
        }
        return false;
    }
}