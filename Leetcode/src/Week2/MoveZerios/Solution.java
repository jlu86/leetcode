package Week2.MoveZerios;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums
 * should be [1, 3, 12, 0, 0].
 * 
 * Note: You must do this in-place without making a copy of the array. Minimize
 * the total number of operations.
 * 
 * @author jielu
 *
 */
public class Solution {
	public void moveZeroes(int[] nums) {
		int toUpdate = 0;
		int nextNonZero = 0;
		while (toUpdate != nums.length && nextNonZero != nums.length) {
			if (nums[toUpdate] == 0) {
				nextNonZero = nextNonZero > toUpdate ? nextNonZero : toUpdate + 1;
				while (nextNonZero != nums.length && nums[nextNonZero] == 0) {
					nextNonZero++;
				}
				if (nextNonZero != nums.length) {
					int temp = nums[nextNonZero];
					nums[nextNonZero] = nums[toUpdate];
					nums[toUpdate] = temp;
				}
			}
			
			toUpdate++;
		}
	}

	@Test
	public void test() {
		Solution solution = new Solution();
		int[] nums1 = new int[] {1};
		solution.moveZeroes(nums1);
		assertEquals(1, nums1[0]);
		
		int[] nums2 = new int[] {0};
		solution.moveZeroes(nums2);
		assertEquals(0, nums2[0]);
		
		int[] nums3 = new int[] {4, 1, 2, 5};
		solution.moveZeroes(nums3);
		assertEquals(4, nums3[0]);
		assertEquals(1, nums3[1]);
		assertEquals(2, nums3[2]);
		assertEquals(5, nums3[3]);
		
		int[] nums4 = new int[] {4, 0, 1, 0, 2, 5, 0};
		solution.moveZeroes(nums4);
		assertEquals(4, nums4[0]);
		assertEquals(1, nums4[1]);
		assertEquals(2, nums4[2]);
		assertEquals(5, nums4[3]);
		assertEquals(0, nums4[4]);
		assertEquals(0, nums4[5]);
		assertEquals(0, nums4[6]);
	}

}
