// Problem - https://leetcode.com/problems/rotate-image/
// Notes - First transpose the image along the diagnonal and then reverse it across the vertical line in the middle

class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }
    
    public void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }

    private void reverse(int[][] matrix) {
        for (int row=0; row<matrix.length; row++) {
            for (int col=0; col<matrix[0].length/2; col++) {
                int temp = matrix[row][col];
                int swapCol = matrix[0].length-1-col;
                matrix[row][col] = matrix[row][swapCol];
                matrix[row][swapCol] = temp;
            }
        }
    }
}
