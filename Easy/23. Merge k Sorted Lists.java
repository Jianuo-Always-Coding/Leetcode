/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode n1, ListNode n2) {
                if (n1.val == n2.val) {
                    return 0;
                }
                return n1.val < n2.val ? -1 : 1;
            }
        });
        for (ListNode l : lists) {
            if (l != null) {
                minHeap.add(l);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (!minHeap.isEmpty()) {
            ListNode temp = minHeap.poll();
            cur.next = temp;
            cur = cur.next;
            temp = temp.next;
            if (temp != null) {
                minHeap.offer(temp);
            }
        }

        return dummy.next;
    }
}