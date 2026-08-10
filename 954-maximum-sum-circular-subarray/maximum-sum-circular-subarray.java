class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        
        int currMax = 0, maxSubarraySum = nums[0];
        int currMin = 0, minSubarraySum = nums[0];

        for (int num : nums) {
            totalSum += num;

            currMax = Math.max(num, currMax + num);
            maxSubarraySum = Math.max(maxSubarraySum, currMax);

            currMin = Math.min(num, currMin + num);
            minSubarraySum = Math.min(minSubarraySum, currMin);
        }
        if (maxSubarraySum < 0) {
            return maxSubarraySum;
        }

        return Math.max(maxSubarraySum, totalSum - minSubarraySum);
    }
}