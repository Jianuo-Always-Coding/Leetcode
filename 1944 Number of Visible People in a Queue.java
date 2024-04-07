class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        // corner case
        if (heights == null || heights.length == 0) {
            return heights;
        }

        int[] result = new int[heights.length];
        Deque<Integer> stack = new ArrayDeque<>();

        stack.offerFirst(heights[heights.length - 1]);
        for (int i = heights.length - 2; i >= 0; i--) {
            if (heights[i] < stack.peekFirst()) {
                stack.offerFirst(heights[i]);
                result[i] = 1;
            } else {
                int count = 0;
                while (!stack.isEmpty() && heights[i] >= stack.peekFirst()) {
                    stack.pollFirst();
                    count++;
                }
                if (!stack.isEmpty()) {
                    count++;
                }
                result[i] = count;
                stack.offerFirst(heights[i]);
            }
        }
        return result;
        
    }
}