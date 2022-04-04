// Problem - https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
// Intuition - https://www.youtube.com/watch?v=gs2LMfuOR9k

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// TC=O(N) ht. of the BST. SC = O(N) Call-stack space
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if (node==null) return null;
        
        // Check if both values p and q are in the right subtree
        if (p.val > node.val && q.val > node.val) {
            return lowestCommonAncestor(node.right, p, q);
        } 

        // Check if both the values p and q are in the left subtree
        else if (p.val < node.val && q.val < node.val) {
            return lowestCommonAncestor(node.left, p, q);
        } 
        
        // When the 'split happens', i.e. one of the values lie on the either side, 
        // we have found the LCA (Lowest Common Ancestor) of the BST
        else {
            return node;
        }   
    }
}