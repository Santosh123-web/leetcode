// Last updated: 9/24/2026, 9:59:13 PM
1class Solution {
2    public int findMinMoves(int[] machines) {
3      int sum = 0;
4      for(int i : machines){
5        sum += i;
6      }
7      int steps = 0;
8      int n = machines.length;
9      int avg = sum / n;
10      int need = 0;
11      for(int d : machines){
12        d -= avg;
13        need += d;
14        steps = Math.max(steps, Math.max(Math.abs(need), d));
15      }
16      if(sum % n != 0){
17        steps = -1;
18      }
19      return steps;
20    }
21}