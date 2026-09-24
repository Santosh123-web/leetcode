// Last updated: 9/24/2026, 9:03:23 PM
1class Solution {
2    public int longestIncreasingPath(int[][] matrix) {
3        int m = matrix.length;
4        int n = matrix[0].length;
5        int[][] dp = new int[m][n];
6        for (int d[] : dp) Arrays.fill(d, -1);
7        for (int i = 0; i < m; i++) {
8            for (int j = 0; j < n; j++) {
9                if (dp[i][j] == -1) dfs(matrix, dp, m, n, i, j, -1);
10            }
11        }
12        int max = Integer.MIN_VALUE;
13        for (int[] d : dp) {
14            for (int i : d) max = Math.max(i, max);
15        }
16        return max;
17    }
18
19    public int dfs(
20        int[][] matrix,
21        int[][] dp,
22        int m,
23        int n,
24        int i,
25        int j,
26        int parent
27    ) {
28        if (
29            i >= m || j >= n || i < 0 || j < 0 || matrix[i][j] <= parent
30        ) return 0;
31        parent = matrix[i][j];
32        if (dp[i][j] != -1) return dp[i][j];
33        int left = dfs(matrix, dp, m, n, i, j - 1, parent);
34        int right = dfs(matrix, dp, m, n, i, j + 1, parent);
35        int bottom = dfs(matrix, dp, m, n, i + 1, j, parent);
36        int top = dfs(matrix, dp, m, n, i - 1, j, parent);
37        dp[i][j] = 1 + Math.max(Math.max(left, right), Math.max(top, bottom));
38        return dp[i][j];
39    }
40}