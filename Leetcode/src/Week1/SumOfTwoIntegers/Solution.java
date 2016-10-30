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
 */
public class Solution {
	public int getSum(int a, int b) {
		// Check the sign for the result
		int absA = Math.abs(a);
		int absB = Math.abs(b);
		boolean negative = false;
		if (a < 0 && b < 0) {
			negative = true;
		} else {
			negative = absA > absB ? a <0 : b < 0;
		}
		
		// Whether add or subtract
		boolean add = true;
		if (a * b < 0) {
			add = false;
		}
		
		// Convert the two integers to bit array
		int length1 = absA/2 + 1;
		int length2 = absB/2 + 1;
		int maxLength = Math.max(length1, length2) + 1;
		// Let the two array be with the same length to simplify the computation later
		int[] array1 = getBitArray(Math.max(absA, absB), maxLength);
		int[] array2 = getBitArray(Math.min(absA, absB), maxLength);
		
		// Add two numbers by operating the two bit arrays
		int[] result = new int[maxLength];
		int k = maxLength - 1;
		int next = 0;
		while (k >= 0) {
			result[k] = array1[k] ^ array2[k] ^ next;
			// If the method is add, and if two of the array1[i], array2[j], next are 1, we need to add 1 to previous bit
			if (add && (((array1[k] & array2[k]) == 1
					|| (array1[k] & next) == 1
					|| (array2[k] & next) == 1))) {
				next = 1;
			} else if (!add
					&& ((next == 0 && array1[k] < array2[k])
					|| (next != 0 && array2[k] != 0))) {
				// if the method is minus
				next = 1;
			} else {
				next = 0;
			}
			k--;
		}
		
		// Convert the result bit array back to integer
		int factor = 1;
		int sum = 0;
		for (int i=0; i<maxLength; i++) {
			sum += result[maxLength-1-i] * factor;
			factor *= 2;
		}
		
		return negative ? -sum : sum;
	}

	public int[] getBitArray(int a, int arrayLength) {
		int[] array = new int[arrayLength];
		int temp = a;
		int index = arrayLength - 1;
		while (temp != 0) {
			array[index] = temp % 2;
			temp = temp / 2;
			index--;
		}
		
		return array;
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
