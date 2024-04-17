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
    public ListNode reverseKGroup(ListNode head, int k) {
        // corner case
        if (k <= 1) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur  = dummy;
        ListNode p1  = head;
        ListNode p2  = head;
        int count = 1;

        while (p2 != null) {
            if (count < k) {
                p2 = p2.next;
                count++;
            } else {
                ListNode next = p2.next;
                reverse(cur, p1, p2, next);
                cur = p1;
                p1 = next;
                p2 = next;
                count = 1;
            }
        }
        return dummy.next;
    }

    private void reverse(ListNode cur, ListNode p1, ListNode p2, ListNode nx) {

        while (p1 != p2) {
            ListNode next = p1.next;
            p1.next = nx;
            nx = p1;
            p1 = next;
        }
        p2.next = nx;
        cur.next = p2;
    }
}