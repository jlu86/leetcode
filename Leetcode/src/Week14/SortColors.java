public class Solution {
    public void sortColors(int[] nums) {
        // First element that is not equal to 0
        int currentLeft = 0;
        // First element that is not equal to 2
        int currentRight = nums.length - 1;
        
        // Current index
        int current = 0;
        int temp;
        while (current <= currentRight) {
            if (nums[current] == 0) {
                // swap with the leftmost one
                while (currentLeft < nums.length && nums[currentLeft] == 0) {
                    currentLeft++;
                }
                if (currentLeft < current) {
                    temp = nums[currentLeft];
                    nums[currentLeft] = nums[current];
                    nums[current] = temp;
                    currentLeft++;
                } else {
                    current++;
                }
            } else if (nums[current] == 2) {
                // swap with the rightmost one
                while (currentRight >= 0 && nums[currentRight] == 2) {
                    currentRight--;
                }
                if (currentRight > current) {
                    temp = nums[currentRight];
                    nums[currentRight] = nums[current];
                    nums[current] = temp;
                    currentRight--;
                } else {
                    current++;
                }
            } else {
                current++;
            }
        }
    }
}
