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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int count = 0;
        int sum = 0;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null || l2 != null || count != 0) {
            if (l1 != null) {
                count = count + l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                count = count + l2.val;
                l2 = l2.next;
            }
            ListNode newNode = new ListNode(count % 10);
            cur.next = newNode;
            cur = cur.next;
            count = count / 10;
        }
        return dummy.next;
    }
}