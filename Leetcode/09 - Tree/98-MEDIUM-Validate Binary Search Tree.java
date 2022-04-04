// Problem - https://leetcode.com/problems/validate-binary-search-tree/
// Notes: Be careful about inclusive bounds (line#26) and calculating upper and lower bounds (line#30)
// BE EXTRA CAREFUL here - It is not sufficient to simply check if the left node val. < root and right node val. > root. 
// Rather the entire left SUBTREE values must be less than root and ENTIRE right SUBTREE values must be greater than root.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean helper(TreeNode node, long min, long max) {
        if (node==null) return true;
        
        if (node.val<=min || node.val>=max) { //Check for inclusive bounds
            return false;
        }
        
        return helper(node.left, min, node.val) && helper(node.right, node.val, max);
    }
}