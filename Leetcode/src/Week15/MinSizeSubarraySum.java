public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        int length = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            length++;
            for (int j=i+1; j<nums.length && sum < s; j++) {
                sum += nums[j];
                length++;
            }
            
            if (sum >= s && length < minLength) {
                minLength = length;
            }
            
            sum = 0;
            length = 0;
        }
        
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
