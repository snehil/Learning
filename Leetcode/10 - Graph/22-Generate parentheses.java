// Problem - https://leetcode.com/problems/generate-parentheses/
// Notes - See how a String is used as temp variable for DFS instead of a List

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        
        dfs(n, result, "", n, n);
        
        return result;
    }
    
    private void dfs(int n, List<String> res, String temp, int openCount, int closeCount) {
        
        if (openCount==0 && closeCount==0) {
            res.add(temp);
            return;
        }
        
        if (openCount!=0) {
            dfs(n, res, temp + "(", openCount-1, closeCount);
        }
        
        if (closeCount>openCount) {
            dfs(n, res, temp + ")", openCount, closeCount-1);
        }
    }
}