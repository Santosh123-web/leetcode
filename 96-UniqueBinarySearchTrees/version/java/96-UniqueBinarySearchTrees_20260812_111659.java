// Last updated: 8/12/2026, 11:16:59 AM
1class Solution {
2    public void solve(char[][] board) {
3        int n=board.length;
4        int m=board[0].length;
5        boolean vis[][]=new boolean[n][m];
6        // top row
7        for(int i=0;i<m;i++){
8            if(board[0][i]=='O' && !vis[0][i]){
9                dfs(board,0,i,vis);
10            }
11        }
12        // left column
13        for(int i=1;i<n-1;i++){
14            if(board[i][m-1]=='O' && !vis[i][m-1]){
15                dfs(board,i,m-1,vis);
16            }
17        }
18        // bottom row
19        for(int i=m-1;i>=0;i--){
20            if(board[n-1][i]=='O' && !vis[n-1][i]){
21                dfs(board,n-1,i,vis);
22            }
23        }
24        // right column
25        for(int i=n-2;i>0;i--){
26            if(board[i][0]=='O' && !vis[i][0]){
27                dfs(board,i,0,vis);
28            }
29        }
30        for(int i=0;i<n;i++){
31            for(int j=0;j<m;j++){
32                if(!vis[i][j] && board[i][j]=='O'){
33                    board[i][j]='X';
34                }
35            }
36        }
37    }
38    public static void dfs(char[][]board,int i,int j,boolean[][]vis){
39        int n=board.length;
40        int m=board[0].length;
41        if(i>n-1 || j>m-1 || i<0 || j<0 || board[i][j]=='X'|| vis[i][j]){
42            return;
43        }
44        vis[i][j]=true;
45        dfs(board,i+1,j,vis);
46        dfs(board,i-1,j,vis);
47        dfs(board,i,j+1,vis);
48        dfs(board,i,j-1,vis);
49    }
50}