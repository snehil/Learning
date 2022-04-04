// Problem - https://leetcode.com/problems/reverse-linked-list/
// Intuition - https://www.youtube.com/watch?v=G0_I-ZF0S38

// Iterative O(n) time O(1) space
    public ListNode reverseList(ListNode head) {
        if (head==null) return null;
        
        ListNode prev = null;
        
        while (head!=null) {
            ListNode temp = head.next;
            head.next=prev;
            prev=head;
            head=temp;
        }      

        return prev;
    }


// Recursive O(n) time, O(n) call stack space
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head==null || head.next==null) return head;
        
        ListNode tail = reverseList(head.next);
        
        head.next.next = head;
        head.next=null;
        
        return tail;
    }
}