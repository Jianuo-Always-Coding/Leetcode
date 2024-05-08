class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;

    // assume capacity >= 1
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = null;
        tail = null;
    }

    // 不需要考虑capacity
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        remove(node);
        append(node);
        return node.value;
    }

    // insert or update?
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            append(node);
        } else {
            if (map.size() == capacity) {
                remove(head);
            }
            Node newNode = new Node(key, value);
            append(newNode);
        }
        return;
    }

    private void remove(Node node) {
        map.remove(node.key);
        if (head == node && tail == node) {
            tail = null;
            head = null;
            return;
        } else if (head == node) {
            head = head.next;
            head.prev = null;
        } else if (tail == node) {
            tail = tail.prev;
            tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        return;
    }

    private void append(Node node) {
        map.put(node.key, node);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
