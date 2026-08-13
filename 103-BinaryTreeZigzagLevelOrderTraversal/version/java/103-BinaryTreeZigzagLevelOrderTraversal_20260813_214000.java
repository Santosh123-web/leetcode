// Last updated: 8/13/2026, 9:40:00 PM
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
17
18    int maxpath = Integer.MIN_VALUE;
19
20    public int maxPathSum(TreeNode root) {
21
22        maxpath = Integer.MIN_VALUE;
23        Maxgain(root);
24        return maxpath;
25        
26    }
27
28    int Maxgain(TreeNode root){
29         
30          if(root == null) return 0;
31
32          int leftgain = Math.max(Maxgain(root.left),0);
33
34          int rightgain = Math.max(Maxgain(root.right),0);
35
36          maxpath = Math.max(maxpath, leftgain+root.val+rightgain);
37
38          return root.val + Math.max(leftgain, rightgain);
39    }
40}