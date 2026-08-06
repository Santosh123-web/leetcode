// Last updated: 8/6/2026, 9:17:16 AM
1class Solution {
2    private void solve(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> path){
3        if( root == null) return; 
4        path.add(root.val);
5        if(root.left == null && root.right == null && targetSum == root.val ) result.add(new ArrayList<>(path));
6        solve(root.left, targetSum-root.val, result, path);
7        solve(root.right, targetSum-root.val, result, path);
8         path.remove(path.size() - 1);
9    }
10    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
11        List<List<Integer>> result = new ArrayList<>();
12        List<Integer> path = new ArrayList<>();
13        if( root == null) return result;
14        solve(root, targetSum, result, path);
15        return result;
16    }
17}