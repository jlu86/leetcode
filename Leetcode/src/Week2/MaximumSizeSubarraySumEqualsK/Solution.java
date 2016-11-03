package Week2.MaximumSizeSubarraySumEqualsK;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Given an array nums and a target value k, find the maximum length of a
 * subarray that sums to k. If there isn't one, return 0 instead.
 * 
 * Note: The sum of the entire nums array is guaranteed to fit within the 32-bit
 * signed integer range.
 * 
 * Example 1: Given nums = [1, -1, 5, -2, 3], k = 3, return 4. (because the
 * subarray [1, -1, 5, -2] sums to 3 and is the longest)
 * 
 * Example 2: Given nums = [-2, -1, 2, 1], k = 1, return 2. (because the
 * subarray [-1, 2] sums to 1 and is the longest)
 * 
 * Follow Up: Can you do it in O(n) time?
 * 
 * @author jielu
 *
 */
public class Solution {
	public int maxSubArrayLen(int[] nums, int k) {
		int maxLength = 0;
		long sum = 0;
		for (int i=0; i<nums.length; i++) {
			for (int j=i; j<nums.length; j++) {
				sum += nums[j];
				if (sum == k) {
					int curLength = j - i + 1;
					maxLength = maxLength > curLength ? maxLength : curLength;
				}
			}
			sum = 0;
		}
		
		return maxLength;
	}
	
	@Test
	public void test1() {
		Solution solution = new Solution();
		
		int[] nums1 = new int[] {};
		assertEquals(0, solution.maxSubArrayLen(nums1, 0));
		
		int[] nums2 = new int[] {1};
		assertEquals(1, solution.maxSubArrayLen(nums2, 1));
		
		int[] nums3 = new int[] {1, -1, 5, -2, 3};
		assertEquals(4, solution.maxSubArrayLen(nums3, 3));
		
		int[] nums4 = new int[] {-2, -1, 2, 1};
		assertEquals(2, solution.maxSubArrayLen(nums4, 1));
		
		int[] nums5 = new int[] {-2, -1, 2, 1};
		assertEquals(0, solution.maxSubArrayLen(nums5, 5));
	}
}
