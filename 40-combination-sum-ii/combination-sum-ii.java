import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }

        // Sort to group duplicates and enable backtracking pruning
        Arrays.sort(candidates);

        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int remain, int start, List<Integer> path, List<List<Integer>> result) {
        // Base case: exact target matched
        if (remain == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Pruning: candidates are sorted; if current val exceeds remaining target, stop iteration
            if (candidates[i] > remain) {
                break;
            }

            // Deduplication: skip duplicate elements at the same tree decision depth
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Choose
            path.add(candidates[i]);

            // Explore: advance index to i + 1 (each element used at most once)
            backtrack(candidates, remain - candidates[i], i + 1, path, result);

            // Unchoose
            path.remove(path.size() - 1);
        }
    }
}