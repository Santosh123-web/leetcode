// Last updated: 8/13/2026, 9:44:53 PM
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12
13     private ListNode getMid(ListNode head) {
14        ListNode slow = head;
15        ListNode fast = head.next;
16        while (fast != null && fast.next != null) {
17            slow = slow.next;
18            fast = fast.next.next;
19
20        }
21        return slow;
22    }
23    private ListNode merge(ListNode head1, ListNode head2) {
24        ListNode mergeNode = new ListNode(-1);
25        ListNode temp = mergeNode;
26
27        while (head1 != null && head2 != null) {
28            if (head1.val <= head2.val) {
29                temp.next = head1;
30                head1 = head1.next;
31                temp = temp.next;
32            } else {
33                temp.next = head2;
34                head2 = head2.next;
35                temp = temp.next;
36            }
37        }
38        while (head1 != null) {
39            temp.next = head1;
40            head1 = head1.next;
41            temp = temp.next;
42        }
43        while (head2 != null) {
44            temp.next = head2;
45            head2 = head2.next;
46            temp = temp.next;
47        }
48        return mergeNode.next;
49    }
50    public ListNode sortList(ListNode head) {
51         // base case
52        if (head == null || head.next == null) {
53            return head;
54        }
55        // step1-> find mid
56        ListNode midNode = getMid(head);
57        // step2-> left and right half
58        ListNode rightHead = midNode.next;
59        midNode.next = null;
60        ListNode lefthalf = sortList(head);
61        ListNode righthalf = sortList(rightHead);
62
63        // step3 -> merge
64        return merge(lefthalf, righthalf);
65        
66    }
67}