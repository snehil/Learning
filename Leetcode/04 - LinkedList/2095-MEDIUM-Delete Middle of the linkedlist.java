// Problem - https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
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
    public ListNode deleteMiddle(ListNode head) {
        if (head==null) return null;
        if (head.next==null) return null; // Handle edge case where input has single element
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy; // This is the trick (initialize both pointers to dummy instead of head)!
        					   // To properly align the deletion point for both even and odd list lenghts
        ListNode slow = dummy;
        
        while (fast.next!=null && fast.next.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }

        slow.next=slow.next.next;
        
        return head;
    }
}


    
    
