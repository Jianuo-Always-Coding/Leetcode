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
        // corner case 
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode n1, ListNode n2) {
                if (n1.val == n2.val) {
                    return 0;
                }
                return n1.val < n2.val ? -1 : 1;
            }
        });
    
        for (ListNode n : lists) {
            if (n != null) {
                minHeap.offer(n);
            }        
        } 

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (!minHeap.isEmpty()) {
            ListNode cur = minHeap.poll();
            prev.next = cur;
            prev = prev.next;
            
            if (cur.next != null) {
                cur = cur.next;
                minHeap.offer(cur);
            }
            

        }
        return dummy.next;
    }
}
