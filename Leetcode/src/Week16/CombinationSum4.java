public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (target == 0) {
            return 0;
        }
        return combinationSum4(nums, 0, target);
    }
    
    public int combinationSum4(int[] nums, int start, int target) {
        if (start >= nums.length) {
            return target == 0 ? 1 : 0;
        }
        
        int num = nums[start];
        int possibilities = target / num;
        int total = 0;
        for (int i = 0; i <= possibilities; i++) {
            total += combinationSum4(nums, start+1, target - num*i);
        }
        
        return total;
    }
}
