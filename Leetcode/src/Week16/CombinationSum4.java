public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        
        // sort the nums in ascending order
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        
        if (nums[0] > target) {
            // the smallest number is still large than target, no combination could be found
            return 0;
        }
        
        return internalCombinationSum4(nums, target);
    }
    
    public int internalCombinationSum4(int[] nums, int target) {
        if (nums[0] > target) {
            return 0;
        }
        
        int total = 0;
        for (int i = 0; i < nums.length && nums[i] <= target; i++) {
            if (target - nums[i] == 0) {
                total++;
            } else {
                total += combinationSum4(nums, target - nums[i]);
            }
        }
        
        return total;
    }
}
