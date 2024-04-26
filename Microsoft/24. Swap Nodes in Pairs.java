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
    public ListNode swapPairs(ListNode head) {
        // corner case
        if (head == null || head.next == null) {
            return head;
        } 
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next.next;
            prev.next = cur.next;
            cur.next.next = cur;
            cur.next = next;
            cur = next;
            prev = prev.next.next;
        }
        return dummy.next;
    }
}