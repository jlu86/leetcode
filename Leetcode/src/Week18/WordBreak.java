public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.isEmpty()) {
            return false;
        }
        
        int maxWordLength = 0;
    
        // Hashset of the dictionary
        HashSet<String> dict = new HashSet<>();
        for (int i = 0; i < wordDict.size(); i++) {
            String word = wordDict.get(i);
            if (word.length() > maxWordLength) {
                maxWordLength = word.length();
            }
            dict.add(word);
        }
        
        // Save the result for last maxWordLength elements
        boolean[] temp = new boolean[maxWordLength];
        for (int i = s.length()-1; i >= 0; i--) {
            boolean found = false;
            StringBuilder sb = new StringBuilder();
            for (int length = 0; length < maxWordLength && i + length < s.length(); length++) {
                sb.append(s.charAt(i+length));
                
                if (dict.contains(sb.toString())) {
                    if (i+length+1 == s.length()) {
                        found = true;
                    } else {
                        found = temp[length];
                    }
                }
                
                if (found) {
                   break;
                }
            }
            
            shiftTempResult(temp, found);
        }
        
        return temp[0]; 
    }
    
    public void shiftTempResult(boolean[] temp, boolean currentResult) {
        for (int i = temp.length-1; i > 0; i--) {
            temp[i] = temp[i-1];
        }
        temp[0] = currentResult;
    }
}
