import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        
        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> charToWord = new HashMap<>();
        Set<String> usedWords = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            if (charToWord.containsKey(ch)) {
                
                if (!charToWord.get(ch).equals(word)) {
                    return false;
                }
            } else {
                
                if (usedWords.contains(word)) {
                    return false;
                }
                charToWord.put(ch, word);
                usedWords.add(word);
            }
        }

        return true;
    }
}