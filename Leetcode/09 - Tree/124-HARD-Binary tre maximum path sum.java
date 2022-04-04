// Problem - https://leetcode.com/problems/binary-tree-maximum-path-sum/

// BE CAREFUL!
// About negative values. These are handled on lines 29 & 30. 

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
    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
    
    private int helper(TreeNode node) {
        if (node==null) return 0;
        
        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);
        max = Math.max(max, node.val + left + right);
        
        return node.val + Math.max(left, right);
    }
}

