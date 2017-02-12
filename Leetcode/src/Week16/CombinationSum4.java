public class Solution {
    // target -> num of combinations
    HashMap<Integer, Integer> intermidiateResult = new HashMap<>();
    
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
        for (int i = nums.length-1; i >= 0; i--) {
            if (nums[i] > target) {
                continue;
            }
            
            int nextTarget = target - nums[i];
            if (nextTarget == 0) {
                total++;
            } else if (intermidiateResult.containsKey(nextTarget)) {
                // already computed the result for nextTarget, use it directly
                total += intermidiateResult.get(nextTarget);
            } else {
                total += combinationSum4(nums, nextTarget);
            }
        }
        
        // cache the intermidiate result
        intermidiateResult.put(target, total);
        
        return total;
    }
}
