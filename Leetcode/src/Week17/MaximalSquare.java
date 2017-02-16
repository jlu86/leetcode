public class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
 
                int delta = 0;
                while (i+delta < matrix.length && j+delta < matrix[0].length && matrix[i][j+delta] == '1') {
                    int k = 0;
                    for (; k <= delta; k++) {
                        if (matrix[i+delta][j+k] != '1' || matrix[i+k][j+delta] != '1') {
                            break;
                        }
                    }
                    
                    if (k < delta) {
                        // if current square reaching to matrix[i][j+delta] doesn't meet, continue to next element
                        break;
                    }
                    
                    delta++;
                }
                
                max = delta > max ? delta : max;
            }
        }
        
        return max*max;
    }
}
