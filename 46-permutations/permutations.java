import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result);
        return result;
    }

    private void backtrack(int[] nums, int first, List<List<Integer>> result) {
        // Base case: all positions filled
        if (first == nums.length) {
            List<Integer> currentPermutation = new ArrayList<>();
            for (int num : nums) {
                currentPermutation.add(num);
            }
            result.add(currentPermutation);
            return;
        }

        for (int i = first; i < nums.length; i++) {
            // Swap current index into position 'first'
            swap(nums, first, i);
            
            // Recurse for remaining positions
            backtrack(nums, first + 1, result);
            
            // Backtrack (restore array state)
            swap(nums, first, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}