public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        
        result[length-1] = 1;
        // First round, make result[i] = product(result[j]) where j > i
        for (int i = length - 2; i >= 0; i--) {
            result[i] = result[i+1] * nums[i+1];
        }
        
        // Second round, make result[i] = result[i] * product(result[j]) where j < i
        int left = 1;
        for (int i = 0; i < length; i++) {
            result[i] = result[i] * left;
            left = left * nums[i];
        }
        
        return result;
    }
}
