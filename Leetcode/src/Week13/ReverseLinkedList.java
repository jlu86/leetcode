/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        
        ListNode current = head.next;
        ListNode tail = head;
        
        while (current != null) {
            tail.next = current.next;
            current.next = head;
            head = current;
            current = tail.next;
        }
        
        return head;
    }
}
