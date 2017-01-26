public class Solution {
    public int romanToInt(String s) {
        char[] array = s.toCharArray();
        int index = 0;
        int sum = 0;
        while (index < array.length) {
            // Check whether the current element is used together with next char to represent one number
            if (index + 1 < array.length && singleNum(array[index], array[index+1])) {
                sum -= getNum(array[index]);
                sum += getNum(array[index+1]);
                index +=2;
            } else {
                sum += getNum(array[index]);
                index++;
            }
        }
        
        return sum;
    }
    
    public boolean singleNum(char first, char second) {
        if (first == 'I' && (second == 'V' || second == 'X')) {
            return true;
        }
        
        if (first == 'X' && (second == 'L' || second == 'C')) {
            return true;
        }
        
        if (first == 'C' && (second == 'D' || second == 'M')) {
            return true;
        }
        
        return false;
    }
    
    public int getNum(char c) {
        switch (c) {
          case 'I':
              return 1;
          case 'V':
              return 5;
          case 'X':
              return 10;
          case 'L':
              return 50;
          case 'C':
              return 100;
          case 'D':
              return 500;
          case 'M':
              return 1000;
          default:
              return 0;
        }
    }
}
