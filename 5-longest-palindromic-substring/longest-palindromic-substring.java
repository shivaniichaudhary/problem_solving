class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0;
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            // Case 1: Odd-length palindrome (center is at char i)
            int len1 = expandAroundCenter(s, i, i);
            // Case 2: Even-length palindrome (center is between char i and i+1)
            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);

            // Update longest bounds when a strictly longer palindrome is found
            if (len > maxLen) {
                maxLen = len;
                // Calculate start index: subtract (len - 1) / 2 to handle both odd and even lengths
                start = i - (len - 1) / 2;
            }
        }

        return s.substring(start, start + maxLen);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Length of palindrome = (right - 1) - (left + 1) + 1 = right - left - 1
        return right - left - 1;
    }
}