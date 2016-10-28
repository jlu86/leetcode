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

	public void rotate(int[] nums, int k) {
		k = k % nums.length;

		int[] tempArray = new int[k];
		// Move k elements to temporary storage
		for (int i = nums.length - k; i < nums.length; i++) {
			tempArray[i - nums.length + k] = nums[i];
		}

		// Shift first nums.length - k elements
		for (int i = nums.length - 1; i >= k; i--) {
			nums[i] = nums[i - k];
		}

		// Move the k elements back to nums
		for (int i = 0; i < k; i++) {
			nums[i] = tempArray[i];
		}
	}
	
	@Test
	public void test() {
		Solution solution = new Solution();
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
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

		int[] nums2 = { 1, 2, 3, 4, 5, 6, 7 };
		solution.rotate(nums2, 7);
		assertEquals(1, nums2[0]);
		assertEquals(2, nums2[1]);
		assertEquals(3, nums2[2]);
		assertEquals(4, nums2[3]);
		assertEquals(5, nums2[4]);
		assertEquals(6, nums2[5]);
		assertEquals(7, nums2[6]);

		int[] nums3 = { 1, 2, 3, 4, 5, 6, 7 };
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
