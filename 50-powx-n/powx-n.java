class Solution {
    public double myPow(double x, int n) {
        long N = n;
        
        // Handle negative exponent without modifying x upfront
        if (N < 0) {
            N = -N;
        }

        double result = 1.0;
        double currentProduct = x;

        while (N > 0) {
            if ((N & 1) == 1) {
                result *= currentProduct;
            }
            currentProduct *= currentProduct;
            N >>= 1;
        }

        // Apply reciprocal at the very end to preserve precision
        return n < 0 ? 1.0 / result : result;
    }
}