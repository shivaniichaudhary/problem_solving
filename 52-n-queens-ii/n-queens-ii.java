
class Solution {
    int count = 0;

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solve(board, 0, n);
        return count;
    }

    void solve(char[][] board, int row, int n) {

        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {

            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';

                solve(board, row + 1, n);

                board[row][col] = '.';
            }
        }
    }

    boolean isSafe(char[][] board, int row, int col, int n) {

        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q')
                return false;
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }

        return true;
    }
}
