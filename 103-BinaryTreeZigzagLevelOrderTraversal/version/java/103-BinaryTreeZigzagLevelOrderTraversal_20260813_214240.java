// Last updated: 8/13/2026, 9:42:40 PM
1class Solution {
2    public void reorderList(ListNode head) {
3        if (head == null) return;
4
5        // Step 1: Find the middle of the list
6        ListNode slow = head, fast = head;
7        while (fast != null && fast.next != null) {
8            slow = slow.next;
9            fast = fast.next.next;
10        }
11
12        // Step 2: Reverse the second half of the list
13        ListNode second = slow.next;
14        slow.next = null;
15        ListNode node = null;
16
17        while (second != null) {
18            ListNode temp = second.next;
19            second.next = node;
20            node = second;
21            second = temp;
22        }
23
24        // Step 3: Merge the two halves
25        ListNode first = head;
26        second = node;
27
28        while (second != null) {
29            ListNode temp1 = first.next, temp2 = second.next;
30            first.next = second;
31            second.next = temp1;
32            first = temp1;
33            second = temp2;
34        }        
35    }
36}