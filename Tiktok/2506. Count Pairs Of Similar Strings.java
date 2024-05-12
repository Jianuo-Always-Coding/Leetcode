class Solution {
    public int similarPairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();

        // 遍历每一个字符串
        for (String s : words) {
            int[] array = new int[26];
            // 对每一个字符串进行编码
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                array[c - 'a'] = 1;
            }
            String pattern = new String(array, 0, array.length);
            if (!map.containsKey(pattern)) {
                map.put(pattern, 1);
            } else {
                map.put(pattern, map.get(pattern) + 1);
            }
        }

        // 统计结果
        int result = 0;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            int num = e.getValue();
            if (num > 1) {
                result = result + num * (num - 1) / 2;
            }
        }
        return result;
    }
}
