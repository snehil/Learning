// Problem - https://leetcode.com/problems/reorder-list/
// Intuition/explanation - https://www.youtube.com/watch?v=S5bfdUTrKLM

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
    public void reorderList(ListNode head) {
    
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        ListNode start = head;
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next!=null && fast.next.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode mid = slow; 
        slow.next = reverseList(slow.next);
        slow=slow.next;
            
        while (slow!=null) {
            dummy.next=start;
            dummy=dummy.next;
            start=start.next;
            
            dummy.next=slow;
            dummy=dummy.next;
            slow=slow.next;
        }
        
        if (mid.val==start.val) {
            dummy.next=new ListNode(start.val);
        }

        head = result.next;
    }
    
    ListNode reverseList(ListNode head) {
        if (head==null || head.next==null) return head;
        
        ListNode tail = reverseList(head.next);
        
        head.next.next = head;
        head.next=null;
        
        return tail;
    }
}
