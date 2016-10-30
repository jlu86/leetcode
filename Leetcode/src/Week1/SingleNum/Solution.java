package Week1.SingleNum;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * 
 * Show Company Tags Show Tags Show Similar Problems
 * 
 * @author jielu
 *
 */
public class Solution {
	public int singleNumber(int[] nums) {
		int result = 0;
		for (int i=0; i<nums.length; i++) {
			result ^= nums[i];
		}
		
		return result;
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
