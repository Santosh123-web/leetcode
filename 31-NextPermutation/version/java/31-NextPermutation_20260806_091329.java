// Last updated: 8/6/2026, 9:13:29 AM
1class Solution {
2
3    int count = 0;
4    boolean[] cols;
5    boolean[] diag1;
6    boolean[] diag2;
7
8    public int totalNQueens(int n) {
9
10        cols = new boolean[n];
11        diag1 = new boolean[2 * n];
12        diag2 = new boolean[2 * n];
13
14        backtrack(0, n);
15
16        return count;
17    }
18
19    private void backtrack(int row, int n) {
20
21        if (row == n) {
22            count++;
23            return;
24        }
25
26        for (int col = 0; col < n; col++) {
27
28            int d1 = row - col + n;
29            int d2 = row + col;
30
31            if (cols[col] || diag1[d1] || diag2[d2])
32                continue;
33
34            cols[col] = true;
35            diag1[d1] = true;
36            diag2[d2] = true;
37
38            backtrack(row + 1, n);
39
40            cols[col] = false;
41            diag1[d1] = false;
42            diag2[d2] = false;
43        }
44    }
45}