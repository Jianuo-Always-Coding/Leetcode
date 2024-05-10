class MedianFinder {
    PriorityQueue<Integer> upper; // mid ~ max
    PriorityQueue<Integer> lower; // mid ~ min

    public MedianFinder() {
        upper = new PriorityQueue<>();
        lower = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if (lower.isEmpty() || num < lower.peek()) {
            lower.add(num);
        } else {
            upper.add(num);
        }
        // balance two pqs
        if (lower.size() > upper.size() + 1) {
            upper.add(lower.poll());
        } else if (upper.size() > lower.size() + 1) {
            lower.add(upper.poll());
        }
    }
    
    public double findMedian() {
        if (lower.size() > upper.size()) {
            return lower.peek();
        } else if (upper.size() > lower.size()) {
            return upper.peek();
        } else {
            return (lower.peek() + upper.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
