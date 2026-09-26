class Solution {
    public String makeSmallestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] != arr[right]) {
                // Choose the smaller character alphabetically for both positions
                char minChar = (char) Math.min(arr[left], arr[right]);
                arr[left] = minChar;
                arr[right] = minChar;
            }
            left++;
            right--;
        }

        return new String(arr);
    }
}