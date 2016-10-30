package Week1.NimGame;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * You are playing the following Nim Game with your friend: There is a heap of
 * stones on the table, each time one of you take turns to remove 1 to 3 stones.
 * The one who removes the last stone will be the winner. You will take the
 * first turn to remove the stones.
 * 
 * Both of you are very clever and have optimal strategies for the game. Write a
 * function to determine whether you can win the game given the number of stones
 * in the heap.
 * 
 * For example, if there are 4 stones in the heap, then you will never win the
 * game: no matter 1, 2, or 3 stones you remove, the last stone will always be
 * removed by your friend.
 * 
 * @author jielu
 *
 */
public class Solution {
	public boolean canWinNim(int n) {
		// timeout
//		if (n <= 3) {
//			return true;
//		}
//		
//		// Record the result for last three elements
//		boolean first = true;
//		boolean second = true;
//		boolean third = true;
//		boolean current = false;
//		// Compute the result for each element from bottom to top
//		for (int i=4; i<=n; i++) {
//			current = !first || !second || !third;
//			first = second;
//			second = third;
//			third = current;
//		}
//		return current;
		
		return n % 4 >=1 && n % 4 <= 3;
	}

	@Test
	public void test() {
		Solution solution = new Solution();
		assertEquals(false, solution.canWinNim(4));
		assertEquals(true, solution.canWinNim(5));
		
	}

}
