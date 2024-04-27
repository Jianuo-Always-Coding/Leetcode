/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // corner case
        if (head == null) {
            return null;
        }

        // 用一个map记录旧点和新点 旧点为key，新点为value
        Map<Node, Node> map = new HashMap<>();
        // 创建一个新头
        Node newHead = new Node(head.val);
        map.put(head, newHead);
        Node cur = newHead; // cur为新list的指针

        while (head != null) {
            if (head.next != null) {
                // 下一个next点没创建
                if (!map.containsKey(head.next)) {
                    Node newNode = new Node(head.next.val);
                    map.put(head.next, newNode);
                }
                cur.next = map.get(head.next);
            }

            // 下一个random点没创建
            if (head.random != null) {
                if (!map.containsKey(head.random)) {
                    Node newNode = new Node(head.random.val);
                    map.put(head.random, newNode);
                }
                cur.random = map.get(head.random);
            }
            // 可以把两次创建的方法封装成一个helper function
            // 移动下一个
            cur = cur.next;
            head = head.next;
        }
        return newHead;

    }
} 