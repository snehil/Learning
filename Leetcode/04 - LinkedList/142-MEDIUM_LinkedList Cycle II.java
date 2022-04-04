// Problem - https://leetcode.com/problems/linked-list-cycle-ii/
// Intuition - https://leetcode.com/problems/linked-list-cycle-ii/discuss/1701055/JavaC%2B%2BPython-best-explanation-ever-happen's-for-this-problem

// Explanation/Intuition - https://leetcode.com/problems/linked-list-cycle-ii/discuss/1701055/JavaC%2B%2BPython-best-explanation-ever-happen's-for-this-problem


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head==null) return null;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast.next!=null && fast.next.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            
            if (fast==slow) {
                slow = head;
                
                while (slow!=fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                
                return fast; // or slow
            }
        }
        
        return null;
    }
}