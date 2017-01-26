public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.equals(needle)) {
            return 0;
        }
        
        if (needle.length() > haystack.length()) {
            return -1;
        }
        
        int haystackIdx = 0;
        for (; haystackIdx < haystack.length(); haystackIdx++) {
            int i = haystackIdx;
            int j = 0;
            while (i < haystack.length() && j < needle.length() && haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            
            if (j == needle.length()) {
                return haystackIdx;
            }
        }
        
        return -1;       
    }
}
