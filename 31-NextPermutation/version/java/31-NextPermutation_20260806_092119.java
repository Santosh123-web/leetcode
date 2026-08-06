// Last updated: 8/6/2026, 9:21:19 AM
1class Solution {
2    public int minimumTotal(List<List<Integer>> triangle) {
3        int row = triangle.size();
4        int[] memo = new int[row];
5
6        for (int i = 0; i < row; i++) {
7            memo[i] = triangle.get(row - 1).get(i);
8        }
9
10        for (int r = row-2; r >= 0; r--) {
11            for (int c = 0; c <= r; c++) {
12                memo[c] = Math.min(memo[c], memo[c+1]) + triangle.get(r).get(c);
13            }
14        }
15
16        return memo[0];        
17    }
18}