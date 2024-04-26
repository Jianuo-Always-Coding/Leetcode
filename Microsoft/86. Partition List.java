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
    public ListNode partition(ListNode head, int x) {
        // corner case
        if (head == null || head.next == null) {
            return head;
        }

        ListNode small = new ListNode(-1);
        ListNode sc = small;
        ListNode largeAndEquals = new ListNode(-1);
        ListNode lc = largeAndEquals;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val < x) {
                sc.next = cur;
                cur = cur.next;
                sc = sc.next;
                sc.next = null;
            } else {
                lc.next = cur;
                cur = cur.next;
                lc = lc.next;
                lc.next = null;
            }
        }

        sc.next = largeAndEquals.next;
        return small.next;
    }
}