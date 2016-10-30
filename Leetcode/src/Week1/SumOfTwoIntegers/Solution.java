package Week1.SumOfTwoIntegers;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the
 * operator + and -.
 * 
 * Example: Given a = 1 and b = 2, return 3.
 * 
 * @author jielu
 *
 * Note: 1. how to represent a negative value with two's complement representation
 *       2. Math.abs(Integer.MIN_VALUE) = Integer.MIN_VALUE, need to convert to long first
 */
public class Solution {
	// Assume the system is with 32 bits
	static int bitSize = 32;
	
	/**
	 * Get the two's complement representation of a integer, describe it as an array
	 */
	public int[] getBitArray(int a) {
		int[] array = new int[bitSize];
		boolean negative = a < 0;

		long temp = Math.abs((long)a);
		int i = bitSize - 1;
		while (temp != 0) {
			array[i] = (int) temp % 2;
			temp = temp / 2;
			i--;
		}

		if (negative) {
			// Get a two's complement representation of a negative
			// Step 1: get the two's complement representation of the absolute
			// value
			// Step 2: flip each bit
			for (int j = 0; j < bitSize; j++) {
				array[j] = flip(array[j]);
			}
			// Step 3: add 1 to the flipped value
			int[] oneArray = new int[64];
			oneArray[bitSize - 1] = 1;
			return addTwoBitArray(array, oneArray);
		}

		return array;
	}
	
	/**
	 * Flip the element 
	 */
	public int flip(int num) {
		return num == 1 ? 0 : 1;
	}

	/**
	 * Compute the sum of two bit array, do not count for negative or not right now
	 */
	public int[] addTwoBitArray(int[] array1, int[] array2) {
		int[] result = new int[bitSize];
		int k = bitSize - 1;
		int next = 0;
		while (k >= 0) {
			result[k] = array1[k] ^ array2[k] ^ next;
			if ((array1[k] & array2[k]) == 1 || (array1[k] & next) == 1 || (array2[k] & next) == 1) {
				next = 1;
			} else {
				next = 0;
			}
			k--;
		}

		return result;
	}

	/**
	 * Get the number representation of given bit array, sign bit needs to be considered.
	 */
	public int getNumFromBitArray(int[] array) {
		if (array[0] == 1) {
			// negative value
			// flip each bit of the two's complement representation of the
			// negative value
			for (int i = 0; i < array.length; i++) {
				array[i] = flip(array[i]);
			}

			// add 1 to the flipped value
			int[] oneArray = new int[bitSize];
			oneArray[bitSize - 1] = 1;
			return -getAbsValueFromBitArray(addTwoBitArray(array, oneArray));
		}

		return getAbsValueFromBitArray(array);
	}

	/**
	 * Get the absolute number representation of given array. The array always represent a positive value.
	 */
	public int getAbsValueFromBitArray(int[] array) {
		int sum = 0;
		int factor = 1;
		for (int i = array.length - 1; i >= 0; i--) {
			sum += array[i] * factor;
			factor *= 2;
		}

		return sum;
	}

	public int getSum(int a, int b) {
		int[] array1 = getBitArray(a);
		int[] array2 = getBitArray(b);
		int[] result = addTwoBitArray(array1, array2);
		return getNumFromBitArray(result);
	}

	@Test
	public void test() {
		Solution solution = new Solution();
		assertEquals(3, solution.getSum(1, 2));
		assertEquals(103, solution.getSum(101, 2));
		assertEquals(0, solution.getSum(0, 0));
		assertEquals(2011, solution.getSum(10, 2001));
		assertEquals(0, solution.getSum(1, -1));
		assertEquals(-9, solution.getSum(1, -10));
		assertEquals(-11, solution.getSum(-1, -10));
		assertEquals(9, solution.getSum(-1, 10));
		assertEquals(-1, solution.getSum(2147483647, -2147483648));
	}

}
