// Last updated: 8/6/2026, 9:09:53 AM
1// Approach -1
2
3class Solution {
4    public boolean isMatch(String s, String p) {
5        return wildcardMatching(p, s) == 1;
6    }
7    
8    private static boolean isAllStars(String S1, int i) {
9        for (int j = 0; j <= i; j++) {
10            if (S1.charAt(j) != '*')
11                return false;
12        }
13        return true;
14    }
15
16    private static int wildcardMatchingUtil(String S1, String S2, int i, int j, int[][] dp) {
17        if (i < 0 && j < 0)
18            return 1;
19        if (i < 0 && j >= 0)
20            return 0;
21        if (j < 0 && i >= 0)
22            return isAllStars(S1, i) ? 1 : 0;
23
24        if (dp[i][j] != -1) return dp[i][j];
25
26        if (S1.charAt(i) == S2.charAt(j) || S1.charAt(i) == '?')
27            return dp[i][j] = wildcardMatchingUtil(S1, S2, i - 1, j - 1, dp);
28        else {
29            if (S1.charAt(i) == '*') {
30                return dp[i][j] = (wildcardMatchingUtil(S1, S2, i - 1, j, dp) == 1 || wildcardMatchingUtil(S1, S2, i, j - 1, dp) == 1) ? 1 : 0;
31            } else {
32                return dp[i][j] = 0;
33            }
34        }
35    }
36
37    private static int wildcardMatching(String S1, String S2) {
38        int n = S1.length();
39        int m = S2.length();
40
41        int dp[][] = new int[n][m];
42        for (int row[] : dp)
43            Arrays.fill(row, -1);
44
45        return wildcardMatchingUtil(S1, S2, n - 1, m - 1, dp);
46    }
47}