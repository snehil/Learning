// Problem - https://leetcode.com/problems/binary-tree-level-order-traversal/

// Things to remember - Queue.offer and Queue.remove APIs

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root==null) {
            return result;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        // Add root node
        List<Integer> member = new ArrayList<>();
        member.add(root.val);
        result.add(member);
        
        while(!q.isEmpty()) {
            TreeNode node = q.remove();
            List<Integer> members = new ArrayList<>();
                
            if (node.left!=null) {
                q.offer(node.left);
                members.add(node.left.val);
            }
                
            if (node.right!=null) {
                q.offer(node.right);
                members.add(node.right.val);
            }
            
            if (members.size()>0) {
                result.add(members);
            }
        }
        
        return result;
    }
}