package Week1.AddTwoNums;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * 
 * @author jielu
 *
 */

public class Solution {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// Find the longer list
		int length1 = 0;
		int length2 = 0;
		for (ListNode current = l1; current != null; current = current.next) {
			length1++;
		}
		
		for (ListNode current = l2; current != null; current = current.next) {
			length2++;
		}
		
		ListNode head1 = l1;
		ListNode head2 = l2;
		if (length1 < length2) {
			head1 = l2;
			head2 = l1;
		}
		
		// Iterate two lists until meeting the end of short list
		int next = 0;
		// Use pre to track the previous node in the long list
		ListNode pre = head1;
		while (head2 != null) {
			int sum = head1.val + head2.val + next;
			head1.val = sum % 10;
			next = sum / 10;
			
			pre = head1;
			head1 = head1.next;
			head2 = head2.next;
		}
		
		while (next != 0 && head1 != null) {
			next = (head1.val + 1) / 10;
			head1.val = (head1.val + 1) % 10;
			pre = head1;
			head1 = head1.next;
		}
		
		if (head1 == null && next != 0) {
			// Append a new node to the end
			ListNode newNode = new ListNode(1);
			newNode.next = null;
			pre.next = newNode;
		}
		
		return length1 >= length2 ? l1 : l2;
	}

	@Test
	public void test() {
	}

}
