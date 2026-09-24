// Last updated: 9/24/2026, 9:56:44 PM
1class Solution {
2    Map<String, Integer> mem = new HashMap<>();
3    public int findMinStep(String board, String hand) {
4        char[] h = hand.toCharArray();
5        Arrays.sort(h);
6        String sorted_hand = new String(h);
7        int res = dfs(board, sorted_hand);
8        return res == Integer.MAX_VALUE? -1: res;
9    }
10    public int dfs(String board, String hand)
11    {
12        if(board.length() == 0) return 0;
13        if(hand.length() == 0) return Integer.MAX_VALUE;
14        String key = board + "#" + hand;
15        if(mem.containsKey(key)) return mem.get(key);
16        int res = Integer.MAX_VALUE;
17        int n = board.length();
18        for(int i=0; i<n; i++)
19        {
20            for(int j=0; j<hand.length(); j++) 
21            {
22                if(j>0 && hand.charAt(j) == hand.charAt(j-1)) continue;
23                boolean worth = false;
24                if(hand.charAt(j) == board.charAt(i)) worth = true;
25                if(i>0 && board.charAt(i) == board.charAt(i-1)) worth = true;
26                if(worth == false) continue;
27                // if worth, insert the char into board
28                String next_board = board.substring(0, i) + hand.charAt(j) + board.substring(i);
29                String next_hand = hand.substring(0, j) + hand.substring(j+1);
30                int next_res = dfs(shrink(next_board), next_hand);
31                if(next_res != Integer.MAX_VALUE)
32                {
33                    res = Math.min(res, next_res + 1);
34                }
35            }
36        }
37        mem.put(key, res);
38        return res;
39    }
40    public String shrink(String board)
41    {
42        int n = board.length();
43        for(int i=0; i<n; )
44        {
45            int j=i;
46            while(j<n && board.charAt(j)==board.charAt(i)) j++;
47            if(j-i>=3)
48            {
49                return shrink(board.substring(0, i) + board.substring(j));
50            }
51            i=j;
52        }
53        return board;
54    }
55}