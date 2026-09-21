// Last updated: 9/21/2026, 9:57:59 PM
1class Solution {
2    int n = 3;
3    int N = n * n;
4    int[][] rows = new int[N][N + 1];
5    int[][] columns = new int[N][N + 1];
6    int[][] boxes = new int[N][N + 1];
7    char[][] board;
8    boolean sudokuSolved = false;
9
10    public boolean couldPlace(int d, int row, int col) {
11        int idx = (row / n) * n + col / n;
12        return rows[row][d] + columns[col][d] + boxes[idx][d] == 0;
13    }
14
15    public void placeNumber(int d, int row, int col) {
16        int idx = (row / n) * n + col / n;
17        rows[row][d]++;
18        columns[col][d]++;
19        boxes[idx][d]++;
20        board[row][col] = (char)(d + '0');
21    }
22
23    public void removeNumber(int d, int row, int col) {
24        int idx = (row / n) * n + col / n;
25        rows[row][d]--;
26        columns[col][d]--;
27        boxes[idx][d]--;
28        board[row][col] = '.';
29    }
30
31    public void placeNextNumbers(int row, int col) {
32        if (row == N - 1 && col == N - 1) sudokuSolved = true;
33        else if (col == N - 1) backtrack(row + 1, 0);
34        else backtrack(row, col + 1);
35    }
36
37    public void backtrack(int row, int col) {
38        if (board[row][col] == '.') {
39            for (int d = 1; d <= 9; d++) {
40                if (couldPlace(d, row, col)) {
41                    placeNumber(d, row, col);
42                    placeNextNumbers(row, col);
43                    if (!sudokuSolved) removeNumber(d, row, col);
44                }
45            }
46        } else placeNextNumbers(row, col);
47    }
48
49    public void solveSudoku(char[][] board) {
50        this.board = board;
51        for (int i = 0; i < N; i++)
52            for (int j = 0; j < N; j++)
53                if (board[i][j] != '.') placeNumber(Character.getNumericValue(board[i][j]), i, j);
54        backtrack(0, 0);
55    }
56}