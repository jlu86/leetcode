public class Solution {
    int[] nums;
    Random random = new Random();

    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    public int pick(int target) {
        int count = 0;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) {
                continue;
            }
            
            count++;
            if (random.nextInt(count) == 0) {
                index = i;
            }
        }
        
        return index;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
