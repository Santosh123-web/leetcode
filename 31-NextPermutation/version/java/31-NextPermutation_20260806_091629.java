// Last updated: 8/6/2026, 9:16:29 AM
1class Solution {
2    public TreeNode sortedListToBST(ListNode head) {
3        if(head==null)
4            return null;
5        if(head.next==null)
6            return new TreeNode(head.val);
7        ListNode slow=head;
8        ListNode fast=head.next.next;
9        while(fast!=null && fast.next!=null){
10            slow=slow.next;
11            fast=fast.next.next;
12        }
13        TreeNode res=new TreeNode(slow.next.val);
14        ListNode righthalf=slow.next.next;
15        slow.next=null;
16        res.left=sortedListToBST(head);
17        res.right=sortedListToBST(righthalf);
18        return res;
19    }
20}