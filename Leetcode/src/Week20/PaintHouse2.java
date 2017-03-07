public class Solution {
    public int minCostII(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        
        // house
        int n = costs.length;
        // color
        int k = costs[0].length;

        int minIdx = -1;
        int preMin = 0;
        int preSecMin = 0;
        for (int i = 0; i < n; i++) {
            // for each house
            int min = Integer.MAX_VALUE;
            int secMin = Integer.MAX_VALUE;
            int newMinIdx = 0;
            for (int j = 0; j < k; j++) {
                // for each color, update the corresponding cost for the current house
                costs[i][j] = costs[i][j] + (j == minIdx ? preSecMin : preMin);
                
                if (costs[i][j] < min) {
                    secMin = min;
                    min = costs[i][j];
                    newMinIdx = j;
                } else if (costs[i][j] < secMin) {
                    secMin = costs[i][j];
                }
            }
            minIdx = newMinIdx;
            preMin = min;
            preSecMin = secMin;
        }
        
        return preMin;
    }
}
