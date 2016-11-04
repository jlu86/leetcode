package Week2.LetterCombinationsofaPhoneNumber;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Given a digit string, return all possible letter combinations that the number
 * could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below.
 * 
 * 
 * 
 * Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd",
 * "ce", "cf"]. Note: Although the above answer is in lexicographical order,
 * your answer could be in any order you want.
 * 
 * @author jielu
 *
 */
public class Solution {
	public List<String> letterCombinations(String digits) {
		List<String> stringResult = new ArrayList<>();
		if (digits == null || digits.isEmpty()) {
			return stringResult;
		}

		char[] array = digits.toCharArray();
		for (int i = 0; i < array.length; i++) {
			if (array[i] > '9' || array[i] < '0') {
				return stringResult;
			}
		}

		List<List<Character>> result = combination(array.length - 1, array);

		for (int i = 0; i < result.size(); i++) {
			List<Character> list = result.get(i);
			// Convert the list to a string
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < list.size(); j++) {
				sb.append(list.get(j));
			}
			stringResult.add(sb.toString());
		}

		return stringResult;
	}

	/**
	 * Get the possible combinations for string [0, endIndex]
	 * 
	 * @param endIndex
	 * @param array
	 * @return
	 */
	public List<List<Character>> combination(int endIndex, char[] array) {
		List<List<Character>> result = new ArrayList<>();

		List<List<Character>> letters = digitToLetters(array[endIndex]);
		if (endIndex == 0) {
			return letters;
		} else {
			// Get all possible lists for string [0, endIndex -1]
			List<List<Character>> subResult = combination(endIndex - 1, array);
			if (letters.isEmpty()) {
				// array[endindex] = 1, just return the sub result
				return subResult;
			}

			if (subResult.isEmpty()) {
				// array[endindex - 1] = 1, just return all the possible letters
				return letters;
			}

			for (int j = 0; j < subResult.size(); j++) {
				for (int i = 0; i < letters.size(); i++) {
					List<Character> newList = getNewListWithNewElement(subResult.get(j), letters.get(i).get(0));
					result.add(newList);
				}
			}
		}

		return result;
	}

	List<Character> getNewListWithNewElement(List<Character> originalList, char newElement) {
		List<Character> newList = new ArrayList<>();
		for (int i = 0; i < originalList.size(); i++) {
			newList.add(originalList.get(i));
		}

		newList.add(newElement);
		return newList;
	}

	/**
	 * Return the matched letters for given digit
	 * 
	 * @param digit
	 * @return
	 */
	List<List<Character>> digitToLetters(char digit) {
		List<List<Character>> letters = new ArrayList<>();

		List<Character> list1 = new ArrayList<>();
		List<Character> list2 = new ArrayList<>();
		List<Character> list3 = new ArrayList<>();
		List<Character> list4 = new ArrayList<>();

		switch (digit) {
		case '0':
			list1.add(' ');
			letters.add(list1);
			break;
		case '1':
			break;
		case '2':
			list1.add('a');
			list2.add('b');
			list3.add('c');
			break;
		case '3':
			list1.add('d');
			list2.add('e');
			list3.add('f');
			break;
		case '4':
			list1.add('g');
			list2.add('h');
			list3.add('i');
			break;
		case '5':
			list1.add('j');
			list2.add('k');
			list3.add('l');
			break;
		case '6':
			list1.add('m');
			list2.add('n');
			list3.add('o');
			break;
		case '7':
			list1.add('p');
			list2.add('q');
			list3.add('r');
			list4.add('s');
			break;
		case '8':
			list1.add('t');
			list2.add('u');
			list3.add('v');
			break;
		case '9':
			list1.add('w');
			list2.add('x');
			list3.add('y');
			list4.add('z');
			break;
		default:
		}

		if (!list1.isEmpty()) {
			letters.add(list1);
		}

		if (!list2.isEmpty()) {
			letters.add(list2);
		}

		if (!list3.isEmpty()) {
			letters.add(list3);
		}

		if (!list4.isEmpty()) {
			letters.add(list4);
		}
		return letters;
	}

	@Test
	public void test() {
		Solution solution = new Solution();
		List<String> result = solution.letterCombinations("23");
		assertEquals(9, result.size());
		List<String> result2 = solution.letterCombinations("123");
		assertEquals(9, result2.size());
		List<String> result3 = solution.letterCombinations("723");
		assertEquals(36, result3.size());

	}

}
