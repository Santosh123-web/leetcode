// Last updated: 8/13/2026, 9:35:53 PM
1class Solution {
2    private int i = 0;
3    private int p = 0;
4
5    public TreeNode buildTree(int[] preorder, int[] inorder) {
6        return build(preorder, inorder, Integer.MIN_VALUE);
7    }
8
9    private TreeNode build(int[] preorder, int[] inorder, int stop) {
10        if (p >= preorder.length) {
11            return null;
12        }
13        if (inorder[i] == stop) {
14            ++i;
15            return null;
16        }
17
18        TreeNode node = new TreeNode(preorder[p++]);
19        node.left = build(preorder, inorder, node.val);
20        node.right = build(preorder, inorder, stop);
21        return node;
22    }
23}