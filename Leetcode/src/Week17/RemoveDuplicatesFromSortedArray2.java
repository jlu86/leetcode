public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        
        int toUpdate = -1;
        int curIdx = 1;
        int numOccurence = 1;
        while (curIdx < nums.length) {
            if (nums[curIdx] == nums[curIdx-1]) {
                // update duplicate occurence
                numOccurence++;
            } else {
                // reset duplicate occurence
                numOccurence = 1;
            }
            
            if (numOccurence > 2 && toUpdate == -1) {
                // first group with more than 2 duplicates met
                toUpdate = curIdx;
            }
            
            if (toUpdate != -1 && numOccurence <= 2) {
                // move the allowed elements forward to last toUpdate position
                nums[toUpdate] = nums[curIdx];
                toUpdate++;
            }
            
            curIdx++;
        }
        
        if (toUpdate == -1) {
            return nums.length;
        }
        
        return toUpdate;
    }
}
