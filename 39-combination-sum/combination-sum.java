import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort candidates to enable early loop pruning
        Arrays.sort(candidates);
        
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int remainingTarget, int start, List<Integer> path, List<List<Integer>> result) {
        // Base Case: Target matched
        if (remainingTarget == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Pruning: Since array is sorted, if current candidate exceeds remainingTarget,
            // all subsequent candidates will also exceed it.
            if (candidates[i] > remainingTarget) {
                break;
            }

            path.add(candidates[i]); // Choose
            
            // Explore: Pass 'i' (not 'i + 1') to allow unlimited reuse of the same element
            backtrack(candidates, remainingTarget - candidates[i], i, path, result);
            
            path.remove(path.size() - 1); // Un-choose (Backtrack)
        }
    }
}