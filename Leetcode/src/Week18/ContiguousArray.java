public class Solution {
    public int findMaxLength(int[] nums) {
        int max = 0;
        int num0 = 0;
        int num1 = 0;
        
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) {
                    num0++;
                }
                
                if (nums[j] == 1) {
                    num1++;
                }
                
                if (num0 == num1) {
                    max = Math.max(max, j - i + 1);
                }
            }
            
            num0 = 0;
            num1 = 0;
        }
        
        return max;
    }
}
