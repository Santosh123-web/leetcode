// Last updated: 8/12/2026, 11:16:29 AM
1/**
2 * Recursive DFS Solution
3 *
4 * Time Complexity: O(N). Each node is visited once.
5 *
6 * Space Complexity: O(H). Stack space.
7 * In case of balanced tree (best case) it will be O(log N) and in case of Skewed Tree (worst case) it will be O(N)
8 *
9 * N = Total number of nodes in the tree. H = Height of the tree.
10 */
11class Solution {
12    public int sumNumbers(TreeNode root) {
13        if (root == null) {
14            return 0;
15        }
16
17        return sumNumbersHelper(root, 0);
18    }
19
20    private int sumNumbersHelper(TreeNode node, int curVal) {
21        if (node == null) {
22            return 0;
23        }
24
25        curVal = curVal * 10 + node.val;
26        if (node.left == null && node.right == null) {
27            return curVal;
28        }
29
30        return sumNumbersHelper(node.left, curVal) + sumNumbersHelper(node.right, curVal);
31    }
32}