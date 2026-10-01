class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[] dp = new boolean[n + 1];
 
        dp[0] = true;
 
        for (int j = 2; j <= n; j += 2) {
            if (p.charAt(j - 1) == '*') {
                dp[j] = dp[j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            boolean[] nextDp = new boolean[n + 1];
            
            for (int j = 1; j <= n; j++) {
                char pChar = p.charAt(j - 1);

                if (pChar != '*') {
                    
                    if (s.charAt(i - 1) == pChar || pChar == '.') {
                        nextDp[j] = dp[j - 1];
                    }
                } else {
                   
                    boolean zeroMatches = nextDp[j - 2];

                    
                    char prevPChar = p.charAt(j - 2);
                    boolean oneOrMoreMatches = (s.charAt(i - 1) == prevPChar || prevPChar == '.') && dp[j];

                    nextDp[j] = zeroMatches || oneOrMoreMatches;
                }
            }

            dp = nextDp; 
        }

        return dp[n];
    }
}