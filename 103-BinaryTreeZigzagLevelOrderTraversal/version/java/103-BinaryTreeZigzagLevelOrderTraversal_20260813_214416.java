// Last updated: 8/13/2026, 9:44:16 PM
1class Solution {
2    public ListNode insertionSortList(ListNode head) {
3        if (head == null) return null;
4
5        ListNode dummy = new ListNode(0); // sorted list head
6
7        ListNode curr = head;
8
9        while (curr != null) {
10            ListNode next = curr.next; // store next node
11
12            // find position in sorted list
13            ListNode prev = dummy;
14
15            while (prev.next != null && prev.next.val < curr.val) {
16                prev = prev.next;
17            }
18
19            // insert curr between prev and prev.next
20            curr.next = prev.next;
21            prev.next = curr;
22
23            curr = next; // move forward
24        }
25
26        return dummy.next;
27    }
28}