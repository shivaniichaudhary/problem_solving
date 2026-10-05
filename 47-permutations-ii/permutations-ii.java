import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        // Sort to group identical elements together for pruning
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];

        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> result) {
        // Base case: full permutation constructed
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip if already used in current branch
            if (used[i]) {
                continue;
            }

            // Deduplication: skip identical elements at the same tree decision level
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            // Choose
            used[i] = true;
            path.add(nums[i]);

            // Explore
            backtrack(nums, used, path, result);

            // Unchoose (Backtrack)
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}