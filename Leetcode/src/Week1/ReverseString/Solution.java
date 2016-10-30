package Week1.ReverseString;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Write a function that takes a string as input and returns the string
 * reversed.
 * 
 * Example: Given s = "hello", return "olleh".
 * 
 * @author jielu
 *
 */
public class Solution {
	public String reverseString(String s) {
		if (s == null || s.isEmpty()) {
			return s;
		}
		
		char[] array = s.toCharArray();
		
		int i = 0;
		int j = array.length - 1;
		char temp;
		for(; i<j;) {
			temp = array[j];
			array[j] = array[i];
			array[i] = temp;
			i++;
			j--;
		}
		
		return new String(array);
	}

	@Test
	public void test() {
		Solution solution = new Solution();
		assertEquals("", solution.reverseString(""));
		assertEquals("h", solution.reverseString("h"));
		assertEquals("he", solution.reverseString("eh"));
		assertEquals("hel", solution.reverseString("leh"));
		assertEquals("helo", solution.reverseString("oleh"));
		assertEquals("hello", solution.reverseString("olleh"));
		assertEquals("", solution.reverseString("Marge, let's \"went.\" I await news telegram."));
	}

}
