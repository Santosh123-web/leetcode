// Last updated: 8/12/2026, 11:12:27 AM
1class Solution {
2
3    int n, m;
4    Boolean[][] memo;
5
6    public boolean dfs(String s1, String s2, String s3, int i, int j) {
7        int k = i + j;
8
9        if(k == s3.length()) return memo[i][j] = true;
10
11        if(memo[i][j] != null) return memo[i][j];
12
13        if(i == n) {
14            if(j < m && s2.charAt(j) == s3.charAt(k)) {
15                return memo[i][j] = dfs(s1, s2, s3, i, j + 1);
16            } 
17
18            return memo[i][j] = false;
19        }
20
21        if(j == m) {
22            if(i < n && s1.charAt(i) == s3.charAt(k)) {
23                return memo[i][j] = dfs(s1, s2, s3, i + 1, j);
24            } 
25
26            return memo[i][j] = false;
27        }
28
29        if(s1.charAt(i) == s2.charAt(j) && s1.charAt(i) == s3.charAt(k)) {
30            return memo[i][j] = dfs(s1, s2, s3, i + 1, j) || dfs(s1, s2, s3, i, j + 1);
31        } else if(s1.charAt(i) == s3.charAt(k)) {
32            return memo[i][j] = dfs(s1, s2, s3, i + 1, j);
33        } else if(s2.charAt(j) == s3.charAt(k))  {
34            return memo[i][j] = dfs(s1, s2, s3, i, j + 1);
35        }
36
37        return memo[i][j] = false;
38
39    }
40
41    public boolean isInterleave(String s1, String s2, String s3) {
42        n = s1.length();
43        m = s2.length();
44
45        memo = new Boolean[n + 1][m + 1];
46
47        if(n + m != s3.length()) return false;
48
49        return dfs(s1, s2, s3, 0, 0);
50
51    }
52}