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
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy; 
        
        ListNode headPoint = head;
        boolean isLast = false; // 最后面是否还有东西
        ListNode start = null; // 记录reverse的起始点，如果不够k个，也记录一下开始位置

        // reverse
        while (headPoint != null) {
            start = headPoint;
            // 循环k-1次，找到最后一个点
            for (int i = 0; i < k - 1; i++) {
                if (headPoint != null) {
                    headPoint = headPoint.next;
                } else {
                    break;
                }
            }
            // 如果不够，直接将start连到最后
            if (headPoint == null) {
                isLast = true;
                break;
            }
            // 连接
            ListNode next = headPoint.next;
            cur.next = reverse(start, headPoint);
            cur = start;
            headPoint = next;
        }
        // 如果最后有内容
        if (isLast) {
            cur.next = start;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode start, ListNode end) {
        // corner case
        if (start == null) {
            return null;
        }
        ListNode prev = null;
        while (start != end) {
            ListNode next = start.next;
            start.next = prev;
            prev = start;
            start = next;
        }
        end.next = prev;
        return end;
    }
}
