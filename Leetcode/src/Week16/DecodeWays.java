public class Solution {
    public int numDecodings(String s) {
        // total starting from [i-1]
        int preTotal = 1;
        // total starting from [i-2]
        int prePreTotal = 1;
        // temp to hold current total starting from [i]
        int temp = 0;
        
        if (s.length() == 0) {
            return 0;
        }
    
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '0') {
                prePreTotal = preTotal;
                // '0' indicates invalid decoding
                preTotal = 0;
                continue;
            }
            
            // treat 'c' as an individual digit
            temp += preTotal;
            if (i+1 < s.length() && (c == '1' || c == '2' && s.charAt(i+1) <= '6')) {
                // treat 'c' and [i+1] as a digit
                temp += prePreTotal;
            }
            
            prePreTotal = preTotal;
            preTotal = temp;
            temp = 0;
        }
        
        return preTotal;
    }
}
