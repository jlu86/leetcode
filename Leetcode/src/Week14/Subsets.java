public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, nums.length - 1);
    }
    
    public List<List<Integer>> subsets(int[] nums, int end) {
        List<List<Integer>> results = new ArrayList<>();
        if (end < 0) {
            results.add(new ArrayList<>());
        } else {
            List<List<Integer>> subsets = subsets(nums, end -1);
            for (int i = 0; i < subsets.size(); i++) {
                List<Integer> set = subsets.get(i);
                results.add(set);
                
                List<Integer> newSet = new ArrayList<>(set);
                newSet.add(nums[end]);
                results.add(newSet);
            }
        }
        
        return results;
    }
}
