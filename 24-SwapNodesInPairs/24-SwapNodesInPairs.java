// Last updated: 7/16/2026, 4:11:11 PM
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        // Create a dummy node to seamlessly handle head updates 🛡️
        ListNode Dummy = new ListNode(0);
        Dummy.next = head;
        ListNode prev = Dummy;
        
        // Loop runs as long as there is a pair of nodes left to swap
        while(prev.next != null && prev.next.next != null){
            ListNode t1 = prev.next;      // First node of the pair
            ListNode t2 = prev.next.next; // Second node of the pair
            
            // Perform the standard 3-pointer link updates to swap t1 and t2 🔄
            t1.next = t2.next;
            t2.next = t1;
            prev.next = t2;
            
            // Advance prev to the end of the swapped pair (which is now t1)
            prev = t1;
        }
        
        return Dummy.next;
    }
}