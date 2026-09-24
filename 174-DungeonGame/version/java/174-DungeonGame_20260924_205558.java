// Last updated: 9/24/2026, 8:55:58 PM
1class Solution {
2    Integer dp[][];
3    private int solve(int i, int j, int arr[][]) {
4        int m = arr.length;
5        int n = arr[0].length;
6        if(i >= m || j >= n) return (int)(-1e7);
7        if(i == m-1 && j == n-1) return Math.min(0, arr[i][j]); //if positive hp then we dont need that
8        
9        if(dp[i][j] !=null) return dp[i][j];
10
11        int right = solve(i,j+1, arr);
12        int down = solve(i+1, j, arr);
13
14        int better = Math.max(right, down); //less negative is better path
15        return dp[i][j] = Math.min(better + arr[i][j], 0);
16    }
17    public int calculateMinimumHP(int[][] dungeon) {
18        int m = dungeon.length;
19        int n = dungeon[0].length;
20        dp = new Integer[m][n];
21        int ans = solve(0,0, dungeon);
22        return Math.abs(ans)+1;
23    }
24
25}