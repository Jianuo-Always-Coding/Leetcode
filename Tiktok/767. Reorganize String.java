class Solution {
    public String reorganizeString(String s) {
        int[] frequency = new int[26];
        // 记录每一个字母出现的次数
        for (char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> frequency[b - 'a'] - frequency[a - 'a']); // 按照剩余个数的多少排序
        // 将所有出现过的字母放到maxHeap中
        for (int i = 0; i < 26; i++) {
            if (frequency[i] > 0) {
                maxHeap.offer((char) ('a' + i));
            }
        }

        StringBuilder rearrangedString = new StringBuilder();
        // 拿出两个不同的字母，这样一定可以保证不同
        while (maxHeap.size() >= 2) {
            char first = maxHeap.poll();
            char second = maxHeap.poll();

            rearrangedString.append(first);
            rearrangedString.append(second);

            // 还能有剩余， 放回去
            if (--frequency[first - 'a'] > 0) {
                maxHeap.offer(first);
            }
            // 还能有剩余，放回去
            if (--frequency[second - 'a'] > 0) {
                maxHeap.offer(second);
            }
        }

        // 剩余的字母超过1个，不可能，返回空
        if (!maxHeap.isEmpty()) {
            char last = maxHeap.poll();
            if (frequency[last - 'a'] > 1) {
                return "";
            }
            rearrangedString.append(last);
        }
        // 返回结果
        return rearrangedString.toString();
    }
}
