// Last updated: 9/24/2026, 9:17:22 PM
1class Solution {
2    public boolean canCross(int[] stones) {
3        int n = stones.length;
4        boolean[][] dp = new boolean[n][n + 1];
5        dp[0][1] = true;
6        
7        for (int i = 1; i < n; i++) {
8            for (int j = 0; j < i; j++) {
9                int jump = stones[i] - stones[j];
10                
11                if (jump <= j + 1) {
12                    dp[i][jump] = dp[j][jump - 1] || dp[j][jump] || dp[j][jump + 1];
13                    if (i == n - 1 && dp[i][jump]) return true;
14                }
15            }
16        }
17        return false;
18    }
19}