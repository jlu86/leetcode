package Week1.RotateArray;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Rotate an array of n elements to the right by k steps.
 * 
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to
 * [5,6,7,1,2,3,4].
 * 
 * Note: Try to come up as many solutions as you can, there are at least 3
 * different ways to solve this problem.
 * 
 * @author jielu
 *
 */
public class Solution {
	class Node {
		int value;
		Node next;
		
		public Node(int value) {
			this.value = value;
		}
	}

	public void rotate(int[] nums, int k) {
		if (nums.length <= 1 || k == 0) {
			return;
		}
		
		// Create a single circular linked list to connect all elements in the given array
		Node pre = new Node(nums[0]);
		Node first = pre;
		for (int i=1; i<nums.length; i++) {
			Node node = new Node(nums[i]);
			pre.next = node;
			pre = node;
		}
		pre.next = first;
		
		// Find out the new head element
		// pre points to last element right now
		int step = nums.length - k % nums.length;
		while (step > 0 ) {
			pre = first;
			first = first.next;
			step--;
		}
		pre.next = null;
		
		int i = 0;
		for (Node cur = first; cur != null; cur = cur.next) {
			nums[i] = cur.value;
			i++;
		}
	}

	@Test
	public void test() {
		Solution solution = new Solution();
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		solution.rotate(nums, 0);
		assertEquals(1, nums[0]);
		assertEquals(2, nums[1]);
		assertEquals(3, nums[2]);
		assertEquals(4, nums[3]);
		assertEquals(5, nums[4]);
		assertEquals(6, nums[5]);
		assertEquals(7, nums[6]);
		
		solution.rotate(nums, 2);
		assertEquals(6, nums[0]);
		assertEquals(7, nums[1]);
		assertEquals(1, nums[2]);
		assertEquals(2, nums[3]);
		assertEquals(3, nums[4]);
		assertEquals(4, nums[5]);
		assertEquals(5, nums[6]);
		
		int[] nums2 = {1, 2, 3, 4, 5, 6, 7};
		solution.rotate(nums2, 7);
		assertEquals(1, nums2[0]);
		assertEquals(2, nums2[1]);
		assertEquals(3, nums2[2]);
		assertEquals(4, nums2[3]);
		assertEquals(5, nums2[4]);
		assertEquals(6, nums2[5]);
		assertEquals(7, nums2[6]);
		
		int[] nums3 = {1, 2, 3, 4, 5, 6, 7};
		solution.rotate(nums3, 9);
		assertEquals(6, nums3[0]);
		assertEquals(7, nums3[1]);
		assertEquals(1, nums3[2]);
		assertEquals(2, nums3[3]);
		assertEquals(3, nums3[4]);
		assertEquals(4, nums3[5]);
		assertEquals(5, nums3[6]);
	}

}
