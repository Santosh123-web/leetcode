// Last updated: 8/6/2026, 9:14:04 AM
1class Solution {
2    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
3        int m = obstacleGrid.length;
4        int n = obstacleGrid[0].length;
5
6        // If the destination is blocked, no path exists
7        if (obstacleGrid[m - 1][n - 1] == 1) {
8            return 0;
9        }
10
11        int[][] dp = new int[m][n];
12
13        // Initialize the last column
14        for (int i = m - 1; i >= 0; i--) {
15            if (obstacleGrid[i][n - 1] == 0) {
16                dp[i][n - 1] = 1;
17            } else {
18                for (int j = i; j >= 0; j--) {
19                    dp[j][n - 1] = 0;
20                }
21                break;
22            }
23        }
24
25        // Initialize the last row
26        for (int i = n - 1; i >= 0; i--) {
27            if (obstacleGrid[m - 1][i] == 0) {
28                dp[m - 1][i] = 1;
29            } else {
30                for (int j = i; j >= 0; j--) {
31                    dp[m - 1][j] = 0;
32                }
33                break;
34            }
35        }
36
37        // Fill the remaining DP table
38        for (int i = m - 2; i >= 0; i--) {
39            for (int j = n - 2; j >= 0; j--) {
40                if (obstacleGrid[i][j] == 1) {
41                    // Obstacle cell
42                    dp[i][j] = 0;
43                } else {
44                    // Sum of paths from the bottom and right cells
45                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
46                }
47            }
48        }
49
50        return dp[0][0];
51    }
52}