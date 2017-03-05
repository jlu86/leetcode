public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // key: sum(0..i)%k, value: oldest i for the key
        HashMap<Integer, Integer> modMap = new HashMap<>();
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = k == 0 ? sum : sum%k;
            if (mod == 0 && i >= 1) {
                return true;
            }
            if (modMap.containsKey(mod)) {
                if (i - modMap.get(mod) >= 2) {
                    return true;
                }
            } else {
                modMap.put(mod, i);
            }
        }
        
        return false;
    }
}
