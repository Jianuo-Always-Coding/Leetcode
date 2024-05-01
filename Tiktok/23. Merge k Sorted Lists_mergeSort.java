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
    ListNode merge(ListNode a, ListNode b) {
        ListNode temp = new ListNode(0);
        ListNode res = temp;

        while (a != null && b != null) {
            if (a.val < b.val) {
                temp.next = a;
                a = a.next;
            } else {
                temp.next = b;
                b = b.next;
            }
            temp = temp.next;
        }

        while (a != null) {
            temp.next = a;
            a = a.next;
            temp = temp.next;
        }

        while (b != null) {
            temp.next = b;
            b = b.next;
            temp = temp.next;
        }
        return res.next;
    }
    
    public ListNode mergeKLists(ListNode[] arr) {
        if(arr.length==0){
            return  null;
        }
        int last = arr.length - 1;

        while (last != 0) {
            int i = 0;
            int j = last;
            while (i < j) {

                arr[i] = merge(arr[i], arr[j]);

                i++;
                j--;
                last--;
            }
        }
        return arr[last];
    }
}