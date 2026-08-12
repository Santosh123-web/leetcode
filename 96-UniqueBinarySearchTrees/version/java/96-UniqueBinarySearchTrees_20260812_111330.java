// Last updated: 8/12/2026, 11:13:30 AM
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    int idx;
18    HashMap<Integer, Integer> map = new HashMap<>();
19
20    public TreeNode buildTree(int[] inorder, int[] postorder) {
21        int l = 0;
22        int r = inorder.length - 1;
23
24        // Step 1: Map inorder values to their indices for O(1) lookup 🗺️
25        for (int i = 0; i <= r; i++) {
26            map.put(inorder[i], i);
27        }
28
29        // Start postorder pointer from the last element (root of whole tree) 📍
30        idx = postorder.length - 1;
31
32        return helper(inorder, postorder, l, r);
33    }
34
35    public TreeNode helper(int[] inorder, int[] postorder, int left, int right) {
36        // Base Case: Invalid range boundary 🍃
37        if (left > right) return null;
38
39        // Step 2: Extract current root value from postorder 🎯
40        int rootVal = postorder[idx--];
41        TreeNode nn = new TreeNode(rootVal);
42
43        // Find root index in inorder array to divide left and right subtrees
44        int mid = map.get(rootVal);
45
46        // Step 3: MUST build RIGHT subtree first because postorder backward walk visits Right before Left! ⚠️
47        nn.right = helper(inorder, postorder, mid + 1, right);
48        nn.left = helper(inorder, postorder, left, mid - 1);
49
50        return nn;
51    }
52}