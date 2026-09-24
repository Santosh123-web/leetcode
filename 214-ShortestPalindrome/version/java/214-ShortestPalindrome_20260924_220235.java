// Last updated: 9/24/2026, 10:02:35 PM
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
17    public Queue<Integer> q=new PriorityQueue<>();
18    //public Queue<Integer> q=new PriorityQueue<>();
19    public int min=Integer.MAX_VALUE;
20    TreeNode prev=null;
21    public int getMinimumDifference(TreeNode root) {
22        inorder(root);
23        while(!q.isEmpty()){
24            int one=q.poll();
25            //int two=0;
26            //if(q.peek()!=null) two=q.poll();
27            if(q.peek()!=null) min=Math.min(min,Math.abs(one-q.peek()));
28        }
29
30        return min;
31    }
32    public void inorder(TreeNode root){
33        if(root!=null){
34            inorder(root.left);
35            /*if(prev!=null){
36                min=Math.min(min,Math.abs(prev.val-root.val));
37            }*/
38            //prev=root;
39            q.offer(root.val);
40            inorder(root.right);
41        }
42    }
43}