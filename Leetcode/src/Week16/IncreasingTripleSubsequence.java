public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int count = 0;
        int low = Integer.MAX_VALUE;
        int high = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
           if (nums[i] > nums[i-1]) {
               count++;
           } else {
               if (count > 0) {
                   // met the first element after ascending
                   if (count >= 2) {
                       return true;
                   }
                   
                   int newHigh = nums[i-1];
                   int newLow = nums[i-1-count];
                   if (newLow > low || newHigh > high) {
                       return true;
                   }
                   low = newLow;
                   high = newHigh;
                   count = 0;
               }
           }
        }
        
        if (count > 0) {
            // last group is in ascending mode
            if (count >= 2) {
                return true;
            }
            
            int newHigh = nums[nums.length-1];
            int newLow = nums[nums.length-1-count];
            if (newLow > low || newHigh > high) {
                return true;
            }
        }
        
        return false;
    }
}
