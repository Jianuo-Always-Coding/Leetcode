/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        // 建立minHeap
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });

        // 将lists中的元素放入minHeap
        if (lists == null || lists.length == 0) {
            return dummy.next;
        }
        for (ListNode n : lists) {
            if (n != null) {
                minHeap.offer(n);
            }
        }

        while (!minHeap.isEmpty()) {
            ListNode n = minHeap.poll();
            System.out.println(n.toString());
            ListNode next = n.next;
            cur.next = n;
            cur = cur.next;
            n.next = null;
            if (next != null) {
                minHeap.offer(next);
            }
        }
        return dummy.next;
    }
}