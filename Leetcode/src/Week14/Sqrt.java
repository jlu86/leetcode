public class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        
        int start = 1;
        int end = x/2;
        while (start <= end) {
            int mid = (start + end) / 2;
            // Didn't get it work first time because of overflow
            double value = (double)mid * (double)mid;
            if (value == x) {
                return mid;
            }
            
            if (value > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return (start + end) / 2;
    }
}
