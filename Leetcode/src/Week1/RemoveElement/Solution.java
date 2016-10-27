package Week1.RemoveElement;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Given an array and a value, remove all instances of that value in place and
 * return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 * 
 * Example: Given input array nums = [3,2,2,3], val = 3
 * 
 * Your function should return length = 2, with the first two elements of nums
 * being 2.
 * 
 * @author jielu
 *
 */
public class Solution {
	public int removeElement(int[] nums, int val) {
		if (nums.length == 0) {
			return 0;
		}
		
		int current = 0;
		int next = 1;
		for (; current < nums.length; current++) {
			if (nums[current] == val) {
				// next might not be updated, so always from the next element or the one updated last time
				next = next < current ? current + 1 : next;
				while (next < nums.length && nums[next] == val) {
					next ++;
				}
				
				if (next < nums.length) {
					nums[current] = nums[next];
					nums[next] = val;
				} else {
					break;
				}
			}
		}
		
		return current;
	}

	@Test
	public void test() {
		Solution solution = new Solution();
		
		int[] nums1 = {2};
		assertEquals(0, solution.removeElement(nums1, 2));
		assertEquals(1, solution.removeElement(nums1, 1));
		
		int[] nums2 = {1, 2, 3, 2, 5};
		assertEquals(3, solution.removeElement(nums2, 2));
		assertEquals(4, solution.removeElement(nums2, 3));
		assertEquals(4, solution.removeElement(nums2, 5));
		assertEquals(5, solution.removeElement(nums2, 7));
	}

}
