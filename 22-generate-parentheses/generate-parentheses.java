import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(int n, int open, int close, StringBuilder path, List<String> result) {
        // Base case: formed a valid combination of length 2 * n
        if (path.length() == 2 * n) {
            result.add(path.toString());
            return;
        }

        // Choice 1: Add opening parenthesis if budget remains
        if (open < n) {
            path.append('(');
            backtrack(n, open + 1, close, path, result);
            path.deleteCharAt(path.length() - 1); // Backtrack
        }

        // Choice 2: Add closing parenthesis if it matches an open parenthesis
        if (close < open) {
            path.append(')');
            backtrack(n, open, close + 1, path, result);
            path.deleteCharAt(path.length() - 1); // Backtrack
        }
    }
}