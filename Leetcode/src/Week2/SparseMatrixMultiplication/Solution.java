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
		// Fill all default value to be Integer.MIN
		for (int i=0; i<m; i++) {
			for (int j=0; j<p; j++) {
				result[i][j] = Integer.MIN_VALUE;
			}
		}
		
		// Update zero elements
		boolean allZero = true;
		// Check all elements in a row are zeroes in A
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (A[i][j] != 0) {
					allZero = false;
					break;
				}
			}
			
			if (allZero) {
				// A[i] are all zeroes, so result[i][0] - result[i][p] will all be zeroes
				for (int k=0; k<p; k++) {
					A[i][k] = 0;
				}
			}
			
			allZero = true;
		}
		
		// Check all elements in a column are zeroes in B
		for (int i=0; i<p; i++) {
			for (int j=0; j<n; j++) {
				if (B[j][i] != 0) {
					allZero = false;
					break;
				}
			}
			
			if (allZero) {
				// All B[x][i] are zeroes, so result[j][0] - result[j][p] will all be zeroes
				for (int k=0; k<m; k++) {
					result[k][i] = 0;
				}
			}
			allZero = true;
		}
		
		int sum = 0;
		for (int i=0; i<m; i++) {
			for (int j=0; j<p; j++) {
				if (result[i][j] != 0) {
					for (int k=0; k<n; k++) {
						sum += A[i][k] * B[k][j];
					}
					result[i][j] = sum;
					sum = 0;
				}
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
