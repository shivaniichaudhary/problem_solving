import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final String[] KEYPAD = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }

        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder path, List<String> result) {
        // Base case: formed a full combination
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }

        // Get letters mapped to current digit
        String letters = KEYPAD[digits.charAt(index) - '0'];

        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));                     // Choose
            backtrack(digits, index + 1, path, result);          // Explore
            path.deleteCharAt(path.length() - 1);                // Un-choose (Backtrack)
        }
    }
}