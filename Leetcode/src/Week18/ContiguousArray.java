public class Solution {
    public int findMaxLength(int[] nums) {
        int max = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        
        // (sum, index of first occurrence)
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            if (sum == 0) {
                max = Math.max(max, i+1);
            } else if (map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        
        return max;
    }
}
