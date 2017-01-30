public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWays(nums, S, 0);
    }
    
    public int findTargetSumWays(int[] nums, int S, int startIdx) {
        int total = 0;
        if (startIdx == nums.length - 1) {
            if (nums[startIdx] == S) {
                total++;
            }
            
            if (nums[startIdx] == -S) {
                total++;
            }
        } else {
            total = findTargetSumWays(nums, S-nums[startIdx], startIdx+1)
            + findTargetSumWays(nums, S+nums[startIdx], startIdx+1);
        }
        
        return total;
    }
}
