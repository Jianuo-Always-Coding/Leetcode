/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode hA = headA;
        ListNode hB = headB;

        // 走完一轮A + B都会指向null，所以没有的话是返回null
        // A：x + same； B : y + same 
        // h1 走的路径 x + same + y
        // h2 走的路径 y + same + x
        while(hA != hB){
            hA = hA == null ? headB : hA.next;
            hB = hB == null ? headA : hB.next;
        }
        return hA;
    }
}