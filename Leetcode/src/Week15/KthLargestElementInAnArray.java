public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int temp = 0;
        for (int i=0; i<k && i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[j] > nums[i]) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        
        return nums[k-1];
    }
}
