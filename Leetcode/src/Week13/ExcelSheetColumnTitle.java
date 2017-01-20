public class Solution {
    public String convertToTitle(int n) {
        StringBuilder reverseResult = new StringBuilder();
        while (n != 0) {
            int mode = n %26;
            n = n/26;
            
            if (mode == 0) {
                reverseResult.append('Z');
                // If the mode is 0, set to 'Z' and minus n
                n--;
            } else {
                reverseResult.append((char)('A' + mode -1));
            }
        }
        
        return reverseResult.reverse().toString();
    }
}
