
class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            long prod = 1;
            long gcd = 0;
            long lcm = 1;

            for (int j = i; j < n; j++) {
                int x = nums[j];

                prod *= x;
                gcd = findGCD(gcd, x);
                lcm = (lcm / findGCD(lcm, x)) * x;

                if (prod == gcd * lcm) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }

    long findGCD(long a, long b) {
        if (b == 0)
            return a;

        return findGCD(b, a % b);
    }
}
