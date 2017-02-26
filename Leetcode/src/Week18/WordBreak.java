public class Solution {
    // substring (i-end), can break to words or not
    HashMap<Integer, Boolean> breakResult = new HashMap<>();
    int maxWordLength = 0;
    
    public boolean wordBreak(String s, List<String> wordDict) {
        // Hashset of the dictionary
        HashSet<String> dict = new HashSet<>();
        
        for (int i = 0; i < wordDict.size(); i++) {
            String word = wordDict.get(i);
            if (word.length() > maxWordLength) {
                maxWordLength = word.length;
            }
            dict.add(word);
        }
        
        return wordBreak(s, 0, dict);  
    }
    
    // return whether the substring (startIdx, s.length()-1) can break to words
    public boolean wordBreak(String s, int startIdx, HashSet<String> dict) {
        boolean canBreak = false;
        StringBuilder sb = new StringBuilder();
        for (int length = 0; length < maxWordLength && startIdx + length < s.length(); length++) {
            int curIdx = startIdx + length;
            sb.append(s.charAt(curIdx));
            if (dict.contains(sb.toString()) {
                // compute the result starting from curIdx+1
                if (curIdx == s.length()+1) {
                    canBreak = true;
                } else if (breakResult.containsKey(curIdx+1)) {
                    canBreak = breakResult.get(curIdx+1);
                } else {
                    canBreak = wordBreak(s, curIdx+1, dict);
                }
            }
        }
        breakResult.put(startIdx, canBreak);
        
        return canBreak;
    }
}
