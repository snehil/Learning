// Problem - https://leetcode.com/problems/subtree-of-another-tree/
// Notes - 
//  		Be careful with the conditions on line# 33,34,36.
//          Notice the "In-line" recursion being performed while traversing the tree (line#27)

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
    public boolean isSubtree(TreeNode root, TreeNode subTree) {
        if (root == null) {
            return false;
        }
        
        if (isSameTree(root, subTree)) {
            return true;
        }
        
        return isSubtree(root.left, subTree) || isSubtree(root.right, subTree);
    }

    private boolean isSameTree(TreeNode first, TreeNode second) {
        if (first==null && second==null) return true;
        if (first==null || second==null) return false;

        if (first.val!=second.val) return false;
        
        return isSameTree(first.left, second.left) && isSameTree(first.right, second.right);
    }
}