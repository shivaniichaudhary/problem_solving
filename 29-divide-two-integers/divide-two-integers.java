class Solution {
    public int divide(int dividend, int divisor) {
        // Edge Case: 32-bit integer overflow (-2^31 / -1 = 2^31 > Integer.MAX_VALUE)
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine sign of quotient
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Convert both integers to negative to prevent overflow at Integer.MIN_VALUE
        int negDividend = dividend < 0 ? dividend : -dividend;
        int negDivisor = divisor < 0 ? divisor : -divisor;

        int quotient = 0;

        // Perform exponential subtraction (in negative arithmetic)
        while (negDividend <= negDivisor) {
            int tempDivisor = negDivisor;
            int multiple = 1;

            // Double the divisor using bitwise shift until it exceeds negDividend
            // tempDivisor >= Integer.MIN_VALUE >> 1 prevents bit-shift overflow
            while (tempDivisor >= (Integer.MIN_VALUE >> 1) && negDividend <= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            negDividend -= tempDivisor;
            quotient += multiple;
        }

        return isNegative ? -quotient : quotient;
    }
}