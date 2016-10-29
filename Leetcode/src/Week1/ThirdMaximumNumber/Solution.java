package Week1.ThirdMaximumNumber;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Given a non-empty array of integers, return the third maximum number in this
 * array. If it does not exist, return the maximum number. The time complexity
 * must be in O(n).
 * 
 * Example 1: Input: [3, 2, 1]
 * 
 * Output: 1
 * 
 * Explanation: The third maximum is 1. Example 2: Input: [1, 2]
 * 
 * Output: 2
 * 
 * Explanation: The third maximum does not exist, so the maximum (2) is returned
 * instead. Example 3: Input: [2, 2, 3, 1]
 * 
 * Output: 1
 * 
 * Explanation: Note that the third maximum here means the third maximum
 * distinct number. Both numbers with value 2 are both considered as second
 * maximum. Subscribe to see which companies asked this question
 * 
 * Show Tags Show Similar Problems
 * 
 * @author jielu
 *
 */
public class Solution {
	public int thirdMax(int[] nums) {
		long first = Long.MIN_VALUE;
		long second = Long.MIN_VALUE;
		long third = Long.MIN_VALUE;
		
		int current = 0;
		for (int i=0; i<nums.length; i++) {
			current = nums[i];
			
			// Check whether we need to shift the maximum value
			if (current > first) {
				third = second;
				second = first;
				first = current;
			} else if (current < first && current > second) {
				third = second;
				second = current;
			} else if (current < second && current > third) {
				third = current;
			}
		}
		
		if (first != Long.MIN_VALUE && second != Long.MIN_VALUE && third != Long.MIN_VALUE) {
			return (int)third;
		} else {
			return (int)first;
		}
	}

	@Test
	public void test() {
		Solution solution = new Solution();
		
		int[] nums1 = new int[] {3, 2, 1};
		assertEquals(1, solution.thirdMax(nums1));
		
		int[] nums2 = new int[] {1, 2};
		assertEquals(2, solution.thirdMax(nums2));
		
		int[] nums3 = new int[] {2, 2, 3, 1};
		assertEquals(1, solution.thirdMax(nums3));
		
		int[] nums4 = new int[] {1, 2, 4, 3, 7, 2, 10, 4, 6};
		assertEquals(6, solution.thirdMax(nums4));
		
		int[] nums5 = new int[] {1, 2, -2147483648};
		assertEquals(-2147483648, solution.thirdMax(nums5));
	}

}
