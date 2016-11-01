package Week2.SparseMatrixMultiplication;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Given two sparse matrices A and B, return the result of AB.
 * 
 * You may assume that A's column number is equal to B's row number.
 * 
 * Example:
 * 
 A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]


     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |

 * 
 * @author jielu
 *
 */
public class Solution {
	public int[][] multiply(int[][] A, int[][] B) {
		int m = A.length;
		int n = B.length;
		int p = B[0].length;
		
		int[][] result = new int[m][p];
		int sum = 0;
		for (int i=0; i<m; i++) {
			for (int j=0; j<p; j++) {
				for (int k=0; k<n; k++) {
					sum += A[i][k] * B[k][j];
				}
				result[i][j] = sum;
				sum = 0;
			}
		}

		return result;
	}

	@Test
	public void test() {
		int[][] A = new int[2][3];
		int[][] B = new int[3][3];
		A[0][0] = 1;
		A[1][0] = -1;
		A[1][2] = 3;
		B[0][0] = 7;
		B[2][2] = 1;

		Solution solution = new Solution();
		int[][] result = solution.multiply(A, B);
		assertEquals(2, result.length);
		assertEquals(3, result[0].length);
		assertEquals(7, result[0][0]);
		assertEquals(-7, result[1][0]);
		assertEquals(3, result[1][2]);
	}

}
