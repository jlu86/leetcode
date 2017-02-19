public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        
        boolean diffMet = false;
        int sIdx = 0;
        int tIdx = 0;
        while (sIdx < s.length() && tIdx < t.length()) {
            if (s.charAt(sIdx) == t.charAt(tIdx)) {
                sIdx++;
                tIdx++;
            } else if (diffMet) {
                // More than 1 diff met, return directly
                return false;
            } else {
                diffMet = true;
                if (s.length() > t.length()) {
                    sIdx++;
                } else if (s.length() < t.length()) {
                    tIdx++;
                } else {
                    sIdx++;
                    tIdx++;
                }
            }
        }
        
        // If length is the same, it is required a diff has been met
        if (sIdx == s.length() && tIdx == t.length()) {
            return diffMet;
        }
        
        // If length is not the same, it is required no diff has been met
        return !diffMet;
    }
}
