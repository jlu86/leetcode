package Week2.AddBinary;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example, a = "11" b = "1" Return "100".
 * 
 * @author jielu
 *
 */
public class Solution {
	public String addBinary(String a, String b) {
		if (a == null || a.isEmpty()) {
			return b;
		}
		
		if (b == null || b.isEmpty()) {
			return a;
		}
		
		char[] arrayA = a.toCharArray();
		char[] arrayB = b.toCharArray();
		int lengthA = arrayA.length;
		int lengthB = arrayB.length;
		int[] resultArray = new int[Math.max(lengthA, lengthB)];
		
		int indexA = lengthA - 1;
		int indexB = lengthB - 1;
		int resultIndex = resultArray.length - 1;
		int next = 0;
		while (indexA >= 0 || indexB >=0) {
			int valueA = indexA >= 0 ? Character.getNumericValue(arrayA[indexA]) : 0;
			int valueB = indexB >= 0 ? Character.getNumericValue(arrayB[indexB]) : 0;
			int current = (valueA + valueB + next) % 2;
			next = (valueA + valueB + next) / 2;
			resultArray[resultIndex] = current;
			
			indexA--;
			indexB--;
			resultIndex--;
		}
		
		StringBuilder result = new StringBuilder();
		if (next > 0) {
			result.append("1");
		}
		for (int i=0; i<resultArray.length; i++) {
			result.append(String.valueOf(resultArray[i]));
		}
		
		return result.toString();
	}

	@Test
	public void test() {
		Solution solution = new Solution();
		
		assertEquals("0", solution.addBinary("0", "0"));
		assertEquals("1", solution.addBinary("1", "0"));
		assertEquals("10001", solution.addBinary("1010", "111"));
		assertEquals("1111", solution.addBinary("1000", "111"));
	}

}
