package Week1.PascalTriangle2;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
 * @author jielu
 *
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {int[] array = new int[rowIndex+1];
        
        array[0] = 1;
		for (int i=0; i<=rowIndex; i++) {
			for (int j = i-1; j > 0; j--) {
				array[j] += array[j-1];
			}
			
			array[i] = 1;
		}
		
        List<Integer> result = new ArrayList<Integer>();
        for (int i=0; i<array.length; i++) {
        	result.add(array[i]);
        }
        return result;
    }
}