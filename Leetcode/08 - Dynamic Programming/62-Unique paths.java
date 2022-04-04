// Problem - https://leetcode.com/problems/unique-paths/

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
                
        return dfs(m, n, 0, 0, dp);
    }
    
    private int dfs(int maxRow, int maxCol, int row, int col, int[][] dp) {
        if (row<0 || row>=maxRow || col<0 || col>=maxCol) {
            return 0;
        } 
        
        if (dp[row][col]!=-1) {
            return dp[row][col];
        }
        
        if (row == maxRow-1 && col == maxCol-1) {
            return 1;
        }
        
        dp[row][col] = dfs(maxRow, maxCol, row+1, col, dp) 
            + dfs(maxRow, maxCol, row, col+1, dp);
        
        return dp[row][col];
    }
}