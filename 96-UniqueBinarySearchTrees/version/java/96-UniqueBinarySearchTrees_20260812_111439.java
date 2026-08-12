// Last updated: 8/12/2026, 11:14:39 AM
1
2class Solution {
3    TreeNode prev=null;
4    public void flatten(TreeNode root) {
5        if (root == null)
6            return;
7        flatten(root.right);
8        flatten(root.left);
9        root.right = prev;
10        root.left = null;
11        prev = root;
12    }
13}