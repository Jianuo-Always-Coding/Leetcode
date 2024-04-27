class MinStack {
    private Deque<Integer> minStack; // 单调非递增
    private Deque<Integer> stack; 
    private int size;

    public MinStack() {
        minStack = new ArrayDeque<Integer>();
        stack = new ArrayDeque<Integer>();
        size = 0;
    }

    public void push(int val) {
        if (size == 0 || val <= minStack.peekFirst()) {
            minStack.offerFirst(val);
        }
        stack.offerFirst(val);
        size++;
    }

    public void pop() {
        if (size == 0) {
            return ;
        }
        size--;

        Integer val = stack.pollFirst();
        if (minStack.peekFirst().equals(val)) {
            minStack.pollFirst();
        }

        return ;
    }

    public int top() {
        return size == 0 ? -1 : stack.peekFirst();
    }

    public int getMin() {
        return size == 0 ? -1 : minStack.peekFirst();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */