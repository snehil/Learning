// Problem - https://leetcode.com/problems/remove-nth-node-from-end-of-list/
// Intuition - https://www.youtube.com/watch?v=XVuQxVej6y8
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
    
        ListNode left = head;
        ListNode right = head;
        
        // Advance right node by n steps
        for (int i=0; i<n;i++) {
            right = right.next;
        }
        
        if (right==null) return head.next;
        
        // Maintain gap between left and right and advance until right reached the end of the list 
        while (right.next!=null) {
            left = left.next;
            right = right.next;
        }
        
        // Delete the node 
        ListNode temp = left.next.next;
        left.next = temp;
        
        return head;
    }
}
