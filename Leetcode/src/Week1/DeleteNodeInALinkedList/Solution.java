package Week1.DeleteNodeInALinkedList;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 237. Delete Node in a Linked List QuestionEditorial Solution My Submissions
 * Total Accepted: 115406 Total Submissions: 256643 Difficulty: Easy
 * Contributors: Admin Write a function to delete a node (except the tail) in a
 * singly linked list, given only access to that node.
 * 
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node
 * with value 3, the linked list should become 1 -> 2 -> 4 after calling your
 * function.
 * 
 * Show Company Tags Show Tags Show Similar Problems
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

	public void deleteNode(ListNode node) {
		if (node == null || node.next == null) {
			return;
		}
		
		ListNode toReplace = node;
		ListNode current = node.next;
		while (true) {
			toReplace.val = current.val;
			if (current.next == null) {
				toReplace.next = null;
				return;
			}
			toReplace = current;
			current = current.next;
		}
		
		
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
