class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        int val = 1;

        while (top <= bottom && left <= right) {
            // Traverse Left to Right
            for (int col = left; col <= right; col++) {
                matrix[top][col] = val++;
            }
            top++;

            // Traverse Top to Bottom
            for (int row = top; row <= bottom; row++) {
                matrix[row][right] = val++;
            }
            right--;

            // Traverse Right to Left
            for (int col = right; col >= left; col--) {
                matrix[bottom][col] = val++;
            }
            bottom--;

            // Traverse Bottom to Top
            for (int row = bottom; row >= top; row--) {
                matrix[row][left] = val++;
            }
            left++;
        }

        return matrix;
    }
}