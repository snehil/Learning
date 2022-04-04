// Problem - https://leetcode.com/problems/kth-smallest-element-in-a-bst/
// Intuition - INORDER traversal gives the sorted order (ASCENDING), and then you can easily get the Kth element.
// TC = O(N), SC = O(N) - call stack space
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
    private int count = 0;
    private int kthSmallest = -1;
    
    public int kthSmallest(TreeNode root, int k) {
        if (root==null) return -1;
        inorder(root, k);
        return kthSmallest;
    }
    
    private void inorder(TreeNode node, int k) {
        if (node==null) return; 
        
        inorder(node.left, k);
        
        count+=1;
        
        if (count==k) {
            kthSmallest = node.val;
        }
        
        inorder(node.right, k);        
    }
}