public class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i] - 1)) {
                // should already be visited before as a sub sequence
                continue;
            }
            
            int length = 0;
            while (set.contains(nums[i] + length)) {
                // compute the consecutive sub sequence
                length++;
            }
            if (length > maxLength) {
                maxLength = length;
            }
        }
        
        return maxLength;
    }
}
