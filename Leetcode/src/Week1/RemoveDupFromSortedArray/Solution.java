package Week1.RemoveDupFromSortedArray;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 * 
 * For example, Given input array nums = [1,1,2],
 * 
 * Your function should return length = 2, with the first two elements of nums
 * being 1 and 2 respectively. It doesn't matter what you leave beyond the new
 * length.
 * 
 * 
 * @author jielu
 *
 */
public class Solution {
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		
		int lastValue = nums[0];
		int indexToUpdate = -1;
		for (int i=1; i<nums.length; i++) {
			if (nums[i] == lastValue) {
				// handle duplicate, just iterate next element
				if (indexToUpdate == -1) {
					indexToUpdate = i;
				}
			} else {
				lastValue = nums[i];
				if (indexToUpdate != -1) {
					// have duplicates before, shift the element to last duplicate one
					nums[indexToUpdate] = nums[i];
					indexToUpdate++;
				}
			}
		}
		
		return indexToUpdate == -1 ? nums.length : indexToUpdate;
		
	}

	@Test
	public void test() {
		Solution solution = new Solution();
		
		int[] nums1 = new int[] {1, 2, 3, 4, 5};
		assertEquals(5, solution.removeDuplicates(nums1));
		
		int[] nums2 = new int[] {1};
		assertEquals(1, solution.removeDuplicates(nums2));
		
		int[] nums3 = new int[] {1, 1, 1, 1, 1};
		assertEquals(1, solution.removeDuplicates(nums3));
		
		int[] nums4 = new int[] {1, 1, 2, 2, 2, 3, 4, 5, 5, 6};
		assertEquals(6, solution.removeDuplicates(nums4));
	}

}
