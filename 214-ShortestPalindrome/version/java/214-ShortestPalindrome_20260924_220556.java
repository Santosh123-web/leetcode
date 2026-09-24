// Last updated: 9/24/2026, 10:05:56 PM
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
17    int sum = 0;
18    public TreeNode convertBST(TreeNode root) {
19        rootSum(root);
20        return root;
21    }
22
23    public void rootSum(TreeNode root){
24        if(root == null){
25            return;
26        }
27
28        rootSum(root.right);
29
30        root.val += sum;
31        sum = root.val;
32
33        rootSum(root.left);
34    }
35}