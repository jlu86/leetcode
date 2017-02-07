public class Solution {
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        
        // Array to record how many numbers are with bit 1 for one specific bit.
        // Since each element is in the range of 0 to 10^9, size 32 is safe.
        int[] bitCount = new int[32];
        
        // For each number, iterate each bit and update the bitCount array on how many 1s in that bit.
        for (int i = 0; i < nums.length; i++) {
            int index = 0;
            int num = nums[i];
            while (num > 0) {
                bitCount[index] += num & 1;
                num = num >> 1;
                index++;
            }
        }
        
        // Count the sum
        for (int i = 0; i < bitCount.length; i++) {
            total += bitCount[i] * (nums.length - bitCount[i]);
        }
        
        return total;
    }
}
