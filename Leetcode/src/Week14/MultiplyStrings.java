public class Solution {
    public String multiply(String num1, String num2) {
        String longNum = num1.length() > num2.length() ? num1 : num2;
        String shortNum = num1.length() > num2.length() ? num2 : num1;
        
        // bug1: missed at 1st submission
        if (shortNum.equals("0")) {
            return shortNum;
        }
        
        List<List<Integer>> result = new ArrayList<>();
        int maxLength = 0;
        for (int i=shortNum.length()-1; i>=0; i--) {
            List<Integer> subResult = multiply(longNum, shortNum.charAt(i), shortNum.length()-1-i);
            result.add(subResult);
            maxLength = subResult.size() > maxLength ? subResult.size() : maxLength;
        }
        
        // Compute the sum for all sub sums
        List<Integer> finalResult = new ArrayList<>();
        int next = 0;
        for (int i=0; i<maxLength; i++) {
            int sum = 0;
            for (int j=0; j<result.size(); j++) {
                List<Integer> subSum = result.get(j);
                if (i < subSum.size()) {
                    sum += subSum.get(i);
                }
            }
            
            finalResult.add((sum+next)%10);
            next = (sum+next)/10;
        }
        while (next != 0) {
            // bug2: next/10 at first submission
            finalResult.add(next%10);
            next = next/10;
        }
        
        // Convert the list to a string
        StringBuilder builder = new StringBuilder();
        for (int i=finalResult.size()-1; i>=0; i--) {
            builder.append(finalResult.get(i));
        }
        
        return builder.toString();
    }
    
    public List<Integer> multiply(String num1, char num2, int numZeroPadding) {
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<numZeroPadding; i++) {
            result.add(0);
        }
        
        int next = 0;
        char[] num = num1.toCharArray();
        int intNum2 = num2 - '0';
        for (int i=num.length-1; i>=0; i--) {
            int intNum1 = num[i] - '0';
            int current = (intNum1 * intNum2 + next) % 10;
            next = (intNum1 * intNum2 + next) / 10;
            result.add(current);
        }
        if (next != 0) {
            result.add(next);
        }
        
        return result;
    }
}
