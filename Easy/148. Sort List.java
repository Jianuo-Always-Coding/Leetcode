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
    public ListNode sortList(ListNode head) {
        // corner case
        if (head == null || head.next == null) {
            return head;
        }

        ListNode midPre = findMid(head);
        ListNode two = midPre.next;
        midPre.next = null;
        ListNode leftHead = sortList(head);
        ListNode rightHead = sortList(two);
        
        ListNode newNode = merge(leftHead, rightHead);
        return newNode;
    }

    private ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (one != null && two != null) {
            if (one.val <= two.val) {
                cur.next = one;
                cur = cur.next;
                one = one.next;
            } else {
                cur.next = two;
                cur = cur.next;
                two = two.next;
            }
        }

        if (one != null) {
            cur.next = one;
        }
        if (two != null) {
            cur.next = two;
        }
        return dummy.next;
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}