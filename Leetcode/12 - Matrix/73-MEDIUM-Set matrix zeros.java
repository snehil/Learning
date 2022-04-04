// Problem - https://leetcode.com/problems/set-matrix-zeroes/
// Intuition - https://www.youtube.com/watch?v=T41rL0L3Pnw
// Notes - Be careful that overwriting the decision space (in this case the 1st row and column) will lead to a mtrix filled
//			with zeros.To avoid this, see the trick below (or in the video above) to save the overlapping cell value for 
//			cell [0][0]

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean isFirstRowZero = false;
        boolean isFirstColZero = false;
        
        // Set first row and column cells to 0 as flags if current cell is zero, except the cell [0][0], use 2 separate variables to track those 2 values. 
        for (int row=0;row<matrix.length; row++) {
            for (int col=0; col<matrix[0].length; col++) {
                if (matrix[row][col]==0) {
                    if (col==0) {
                        isFirstColZero = true;
                    } else {
                        matrix[0][col] = 0;   
                    }
                    
                    if (row==0) {
                        isFirstRowZero=true;
                    } else {
                        matrix[row][0] = 0;
                    }
                }
            }
        }
        
        // Set cells to zero (except first row and column)
        for (int row=1; row<matrix.length; row++) {
            for (int col=1; col<matrix[0].length; col++) {
                if (matrix[0][col]==0 || matrix[row][0]==0) {
                    matrix[row][col]=0;
                }
            }
        }
        
        // Update first row
        for (int col=0; col<matrix[0].length; col++) {
            if (isFirstRowZero) {
                matrix[0][col]=0;
            }   
        }
        
        // Update first column
        for (int row=0; row<matrix.length; row++) {
            if (isFirstColZero) {
                matrix[row][0]=0;
            }
        }
    }
}
