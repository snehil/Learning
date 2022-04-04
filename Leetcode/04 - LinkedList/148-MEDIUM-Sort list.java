// Problem - https://leetcode.com/problems/sort-list/
// SEE this EXPLANATION! - https://stackoverflow.com/questions/71443824/merge-sort-linkedlist-stackoverflow-error
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
    public ListNode sortList(ListNode head) {
        if (head==null || head.next==null) return head;

        ListNode fast = head.next;
        ListNode slow = head;
        
        // Find the mid-point of the list
        while (fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }

        // Split the list
        ListNode second = slow.next;
        slow.next=null;
        
        // Sort each half
        head = sortList(head);
        second = sortList(second);
        
        // Merge
        return merge(head, second);
    }
    
    private ListNode merge(ListNode first, ListNode second) {
        if (first==null) return second;
        if (second==null) return first;
        
        ListNode result = new ListNode(0);
        ListNode head = result;
        
        while (first!=null && second!=null) {
            if (first.val<second.val) {
                result.next = first;
                first=first.next;
            } else {
                result.next = second;
                second=second.next;
            }
            
            result=result.next;
        }
        
        if (first!=null) {
            result.next = first;
            result=result.next;
        }
        
        if (second!=null) {
            result.next = second;
            result=result.next;
        }
        
        return head.next;
    }
}