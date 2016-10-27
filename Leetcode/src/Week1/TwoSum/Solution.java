package Week1.TwoSum;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

/**
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Example: Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1]. UPDATE (2016/2/13): The
 * return format had been changed to zero-based indices. Please read the above
 * updated description carefully.
 * 
 * 
 * @author jielu
 *
 */
public class Solution {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i=0; i<nums.length; i++) {
			int left = target - nums[i];
			if (map.containsKey(left)) {
				return new int[]{map.get(left), i};
			}
			
			map.put(nums[i], i);
		}
		
		return null;
	}

	@Test
	public void test() {
		Solution solution = new Solution();
		int[] nums = {2, 7, 11, 15};
		int[] result = solution.twoSum(nums, 9);
		assertEquals(2, result.length);
		assertEquals(0, result[0]);
		assertEquals(1, result[1]);
		
		int[] result2 = solution.twoSum(nums, 22);
		assertEquals(2, result2.length);
		assertEquals(1, result2[0]);
		assertEquals(3, result2[1]);
	}

}
