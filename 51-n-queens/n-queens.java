import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] queens = new int[n]; // Stores column index of queen at each row
        backtrack(0, 0, 0, 0, n, queens, result);
        return result;
    }

    private void backtrack(int row, int cols, int diag1, int diag2, int n, int[] queens, List<List<String>> result) {
        if (row == n) {
            result.add(constructBoard(queens, n));
            return;
        }

        // Mask representing available columns (1s indicate valid spots)
        int availablePositions = ~((cols | diag1) | diag2) & ((1 << n) - 1);

        while (availablePositions != 0) {
            // Extract the lowest set bit (first valid column)
            int bit = availablePositions & -availablePositions;
            
            // Get 0-indexed column from bit position
            int col = Integer.numberOfTrailingZeros(bit);
            queens[row] = col;

            // Recurse to next row with updated masks
            backtrack(row + 1, 
                      cols | bit, 
                      (diag1 | bit) >> 1, 
                      (diag2 | bit) << 1, 
                      n, 
                      queens, 
                      result);

            // Clear the lowest set bit to try the next available column
            availablePositions &= availablePositions - 1;
        }
    }

    private List<String> constructBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>(n);
        for (int r = 0; r < n; r++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[r]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}