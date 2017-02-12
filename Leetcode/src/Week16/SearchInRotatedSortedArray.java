public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        
        // Search the pivot
        int pivotIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] < nums[i-1]) {
                pivotIdx = i;
            }
        }
        
        if (target >= nums[pivotIdx] && target <= nums[nums.length-1]) {
            return binarySearch(nums, pivotIdx, nums.length-1, target);
        }
        
        if (pivotIdx > 0 && target >= nums[0] && target <= nums[pivotIdx-1]) {
            return binarySearch(nums, 0, pivotIdx-1, target);
        }
        
        return -1;
    }
    
    int binarySearch(int[] nums, int start, int end, int target) {
        int mid = (start + end) / 2;
        if (target == nums[mid]) {
            return mid;
        }
        
        if (target > nums[mid] && mid+1 <= end) {
            return binarySearch(nums, mid+1, end, target);
        }
        
        if (target < nums[mid] && mid-1 >= start) {
            return binarySearch(nums, start, mid-1, target);
        }
        
        return -1;
    }
}
