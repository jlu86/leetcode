public class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        
        StringBuilder builder = new StringBuilder();
        String seq = countAndSay(n-1);
        char[] seqArray = seq.toCharArray();
        int count = 0;
        int index = 0;
        char current = seqArray[index];
        while (index < seqArray.length) {
            if (current == seqArray[index]) {
                count++;
                index++;
                continue;
            }
            
            builder.append(String.valueOf(count)).append(String.valueOf(current));
            count = 0;
            current = seqArray[index];
        }
        // append the last set
        if (count > 0) {
            builder.append(String.valueOf(count)).append(String.valueOf(current));
        }
        
        return builder.toString();
    }
}
