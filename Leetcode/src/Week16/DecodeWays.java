public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        return numDecodings(s.toCharArray(), 0);
    }
    
    public int numDecodings(char[] array, int idx) {
        if (idx == array.length) {
            // All the elements are iterated, return 1 encoding way
            return 1;
        }
        
        char first = array[idx];
        if (first == '0') {
            // Individual '0' is not a valid encoding 
            return 0;
        }
        
        if (idx == array.length - 1) {
            // Only one element is left
            return 1;
        }
        
        char second = array[idx+1];
        int total = 0;
        if (first == '1' || (first == '2' && second <= '6')) {
            total += numDecodings(array, idx+1) + numDecodings(array, idx+2);
        } else {
            total += numDecodings(array, idx+1);
        }
        
        return total;
    }
}
