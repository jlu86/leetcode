public class Solution {
    public int hIndex(int[] citations) {
        // Sort the citations in ascending order first
        for (int i = 0; i < citations.length-1; i++) {
            for (int j = i + 1; j < citations.length; j++) {
                if (citations[j] < citations[i]) {
                    int temp = citations[j];
                    citations[j] = citations[i];
                    citations[i] = temp;
                }
            }
        }
        
        // Check and update h-index
        int max = 0;
        for (int i = citations.length -1; i >= 0; i--) {
            int current = citations.length - i;
            if (citations[i] < current) {
                break;
            }
            if ((i-1 < 0) || (i-1 >= 0 && citations[i-1] <= current)) {
                max = current > max ? current : max;
            }
        }
        
        return max;
    }
}
