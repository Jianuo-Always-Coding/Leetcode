class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // 因为要找后面最近的最大的，所以从最后一个开始找，然后不断更新
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[nums.length];
        // 从最后一个开始放，因为最后一个邻近的第一个是第一个
        for (int i = nums.length - 1; i >= 0; i--) {
            st.push(nums[i]);
        }

        //从最后一个开始便利
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i]) {
                st.pop();
            }
            // 没有比他大的了
            if (st.isEmpty())
                v[i] = -1;
            // 有比他大的
            else
                v[i] = st.peek();
            // 更新到目前为止最大的
            st.push(nums[i]);
        }
        return (v);
    }
}
