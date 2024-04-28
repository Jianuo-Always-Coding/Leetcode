class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>(); // monotonic stack decending ，放index
        int[] result = new int[temperatures.length];

        // 一旦发现遇到高气温，不断放结果
        for (int i = 0 ; i < temperatures.length; i++) {
            while (!stack.isEmpty()) {
                int firstTemp = temperatures[stack.peekFirst()];
                if (temperatures[i] > firstTemp) {
                    int index = stack.pollFirst();
                    result[index] = i - index;
                } else {
                    break;
                }
            }
            stack.offerFirst(i);
        }
        return result;
    }
}