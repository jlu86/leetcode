package Week13.PalindromeLinkedList;


  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        
        // Copy the linked list in a reverse order
       ListNode copy = new ListNode(head.val);
       ListNode current = head;
       current = current.next;
       while (current != null) {
           ListNode newHead = new ListNode(current.val);
           newHead.next = copy;
           copy = newHead;
           current = current.next;
       }
       
       // Compare the two linked list are equal
       while (head != null) {
           if (head.val != copy.val) {
               return false;
           }
           
           head = head.next;
           copy = copy.next;
       }
       
       return true;
    }
}
