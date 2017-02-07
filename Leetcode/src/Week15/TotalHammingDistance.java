public class Solution {
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        
        for (int i=0; i<nums.length-1; i++) {
            for (int j=i+1; j<nums.length; j++) {
                total += hammingDistance(nums[i], nums[j]);
            }
        }
        
        return total;
    }
    
    public int hammingDistance(int x, int y) {
        int val = x ^ y;
        int count = 0;
        while (val != 0) {
            count++;
            val &= val - 1;
        }
        
        return count;
    }
}
