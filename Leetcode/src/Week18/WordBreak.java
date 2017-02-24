public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>();
        for (int i = 0; i < wordDict.size(); i++) {
            dict.add(wordDict.get(i));
        }
        
        // record all the words met so far
        Stack<String> existingWords = new Stack<>();
        // the start index of current word
        int lastStartIdx = 0;
        // track current word
        StringBuilder sb = new StringBuilder();
        // current index
        int i = 0;
        while (true) {
            for (; i < s.length(); i++) {
                sb.append(s.charAt(i));
                String word = sb.toString();
                if (dict.contains(word)) {
                    // a word is met
                    existingWords.push(word);
                    // reset all the variables
                    lastStartIdx = i+1;
                    sb = new StringBuilder();
                }
            }
            
            if (lastStartIdx == s.length()) {
                // the last set is also a word, return directly
                return true;
            }
            
            // the last set of characters is not a word, backtrace and try again
            if (existingWords.empty()) {
                // can not back anymore
                return false;
            }
            
            // back to the last word and try again
            sb = new StringBuilder(existingWords.pop());
            i = lastStartIdx;
            lastStartIdx = i - sb.length();
        }
    }
}
