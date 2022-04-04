// Problem - https://leetcode.com/problems/number-of-islands/submissions/
// Note - Notice the offset trick on line#27

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        
        for (int row=0;row<grid.length; row++) {
            for (int col=0; col<grid[0].length; col++) {
                if (grid[row][col]=='1') {
                    count+=1;
                    dfs(grid, row, col);
                }
            }
        }
        
        return count;
    }
    
    private void dfs(char[][] grid, int row, int col) {
        if (row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]!='1') {
            return;
        }
        
        grid[row][col] = '0';
          
        int[][] offsets = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}};
        
        for (int[] offset: offsets) {
           dfs(grid, row+offset[0], col+offset[1]);
        }
    }
}