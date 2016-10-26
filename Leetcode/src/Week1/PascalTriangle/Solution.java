package Week1.PascalTriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * 
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 *
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
       List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < numRows; i++) {
        	List<Integer> row = new ArrayList<Integer>();
        	
        	row.add(1);
        	for (int j = 1; j <= i-1; j++) {
        		row.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
        	}
        	if (i >= 1) {
        		row.add(1);
        	}
        	
        	result.add(row);
        }
        
        return result;
    }
}