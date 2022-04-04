// PRoblem: https://leetcode.com/problems/merge-k-sorted-lists/
// Intuition: https://www.youtube.com/watch?v=kpCesr9VXDA
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
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> heap = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.val, o2.val));
        
        ListNode head = new ListNode(0);
        ListNode tail = head;
        
        for (ListNode node : lists) {
            if (node != null) {
                heap.offer(node);
            }
        }
        
        while (!heap.isEmpty()) {
            tail.next = heap.poll();
            tail = tail.next;
            
            if (tail.next != null) {
                heap.offer(tail.next);
            }
        }
        
        return head.next;
    }
}