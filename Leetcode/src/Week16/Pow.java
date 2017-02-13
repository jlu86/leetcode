public class Solution {
    public double myPow(double x, int n) {
        if (x == 0 || x == 1) {
            return x;
        }
        
        return n >= 0 ? internalMyPow(x, n) : 1/internalMyPow(x, Math.abs(n));
    }
    
    // n is always non-negative
    public double internalMyPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        
        double temp = internalMyPow(x, n/2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            return temp * temp * x;
        }
    }
}
