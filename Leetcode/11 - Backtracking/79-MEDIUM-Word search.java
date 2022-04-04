// Problem - https://leetcode.com/problems/word-search/
// Notes - Be extremely careful that this is a backtracking problem and not just a 
//			DFS problem. Notice the trick where temp variable (line#31) is used
// 			to store backtracking state. This is used to mark visited nodes and then
//			unmark them so that the backtracking can work properly.

class Solution {
    public boolean exist(char[][] board, String word) {
        for (int row=0;row<board.length;row++) {
            for(int col=0; col<board[0].length; col++) {
                if (dfs(board, word, 0, row, col)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int idx, int row, int col) {
        if (idx>=word.length() || row<0 || col<0 || row>=board.length || col>=board[0].length || board[row][col]=='0') {
            return false;
        }
        
        if (idx==word.length()-1 && board[row][col]==word.charAt(idx)) {
            return true;
        }
        
        if (word.charAt(idx)!=board[row][col]) {
            return false;
        } 
        
        char temp = board[row][col];
        board[row][col] = '0';

        boolean top = dfs(board, word, idx+1, row-1, col);
        boolean bottom = dfs(board, word, idx+1, row+1, col);
        boolean left = dfs(board, word, idx+1, row, col-1);
        boolean right = dfs(board, word, idx+1, row, col+1);
        
        board[row][col] = temp;
        
        return top || bottom || left || right;
    }
}
