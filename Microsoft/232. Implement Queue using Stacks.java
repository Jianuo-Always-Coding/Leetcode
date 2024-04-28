class MyQueue {
    private Deque<Integer> s1;
    private Deque<Integer> s2;
    private Integer size;

    public MyQueue() {
        // Write your solution here.
        s1 = new ArrayDeque<Integer>();
        s2 = new ArrayDeque<Integer>();
        size = 0;
    }

    public void push(int x) {
        s2.offerFirst(x);
        size++;
    }

    public int pop() {
        // 没有元素怎么办
        if (s1.isEmpty()) {
            move(s1, s2);
        }
        size--;

        return s1.pollFirst();
    }

    public int peek() {
        // 没有元素怎么办
        if (s1.isEmpty()) {
            move(s1, s2);
        }

        return s1.peekFirst();
    }

    public boolean empty() {
        return size == 0 ? true : false;
    }

    // move from s2 -> s1
    private void move(Deque<Integer> s1, Deque<Integer> s2) {
        while (!s2.isEmpty()) {
            s1.offerFirst(s2.pollFirst());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */