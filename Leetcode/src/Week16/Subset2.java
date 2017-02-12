public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // sort the input first to group duplicates
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        
        return subsetsWithDup(nums, nums.length-1);
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums, int endIdx) {
        List<List<Integer>> list = new ArrayList<>();
        if (endIdx < 0) {
            list.add(new ArrayList<>());
            return list;
        }
        
        // search left until meet the last duplicate
        int num = nums[endIdx];
        int occurence = 0;
        while (endIdx - occurence >= 0 && nums[endIdx-occurence] == num) {
            occurence++;
        }
        int nextIdx = endIdx - occurence;
        // get the subset list for elements until index nextIdx
        List<List<Integer>> subResult = subsetsWithDup(nums, nextIdx);
        for (int i = 0; i < subResult.size(); i++) {
            // update each subset
            for (int j = 0; j <= occurence; j++) {
                // v1: List<Integer> subset = subResult.get(i); refers to the same list for all occurences, thus unexpected result
                List<Integer> subset = new ArrayList<>(subResult.get(i));
                // update each combination of 'num'
                for (int k = 0; k < j; k++) {
                    subset.add(num);
                }
                list.add(subset);
            }
        }
        
        return list;
    }
}
