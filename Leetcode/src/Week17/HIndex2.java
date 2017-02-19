public class Solution {
    public int hIndex(int[] citations) {
        return hIndex(citations, 0, citations.length-1);
    }
    
    public int hIndex(int[] citations, int start, int end) {
        if (start > end) {
            return 0;
        }
        
        int mid = (start + end) / 2;
        int hindex = citations.length - mid;
        if (citations[mid] < hindex) {
            // check right side
            return hIndex(citations, mid+1, end);
        }
        
        if (citations[mid] >= hindex && (mid == start || citations[mid-1] <= hindex)) {
            return hindex;
        }
        
        // check left side
        return hIndex(citations, start, mid-1);
    }
}
