public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] alphabet = new int[26];
        alphabet = resetAlphabet(alphabet);
        
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                int index = c - 'a';
                alphabet[index] += 1;
            }
            
            String key = toKey(alphabet);
            List<String> value = new ArrayList<>();
            if (map.containsKey(key)) {
                value = map.get(key);
            }
            value.add(str);
            map.put(key, value);
            
            alphabet = resetAlphabet(alphabet);
        }
        
        return new ArrayList<>(map.values());
    }
    
    private int[] resetAlphabet(int[] array) {
        for (int i = 0; i < 26; i++) {
            array[i] = 0;
        }
        
        return array;
    }
    
    private String toKey(int[] array) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                continue;
            }
            char c = (char)('a' + i);
            builder.append(c).append(array[i]);
        }
        
        return builder.toString();
    }
}
