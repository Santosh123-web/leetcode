// Last updated: 8/13/2026, 9:36:39 PM
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
16/**
17 * Definition for a binary tree node.
18 * public class TreeNode {
19 *     int val;
20 *     TreeNode left;
21 *     TreeNode right;
22 *     TreeNode() {}
23 *     TreeNode(int val) { this.val = val; }
24 *     TreeNode(int val, TreeNode left, TreeNode right) {
25 *         this.val = val;
26 *         this.left = left;
27 *         this.right = right;
28 *     }
29 * }
30 */
31class Solution {
32    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
33
34     Queue<TreeNode> queue = new LinkedList<>();
35
36    List<List<Integer>> list = new ArrayList<>();
37
38    if(root==null) return new ArrayList<>();
39
40    queue.offer(root);
41
42boolean turn = false;
43    while(!queue.isEmpty()){
44
45List<Integer> ans = new ArrayList<>();
46       
47int s = queue.size();
48        for(int i =0; i < s; i++) {
49            TreeNode node = queue.poll();
50            ans.add(node.val);
51            if(node.left!=null) queue.offer(node.left);
52                if(node.right!=null) queue.offer(node.right);
53                
54                
55                
56            }
57       
58 
59if(turn) Collections.reverse(ans);
60   turn = !turn;       
61     
62        list.add(new ArrayList<>(ans));
63
64    }
65
66
67    return list;}
68}