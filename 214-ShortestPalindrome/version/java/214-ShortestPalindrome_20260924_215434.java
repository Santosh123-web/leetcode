// Last updated: 9/24/2026, 9:54:34 PM
1class Solution {
2    public String smallestGoodBase(String n) {
3        long low = Long.valueOf(n);
4        int high = (int) (Math.log(low + 1) / Math.log(2)) - 1;
5        
6        long result = low - 1;
7        for (int m = high; m > 1; m--) {
8            long k = (long) Math.pow(low, 1.0 / m);
9            if (geometric(k, m) == low) return String.valueOf(k);
10        }
11        return String.valueOf(result);
12    }
13
14    private long geometric(long base, int m) {
15        long result = 0;
16        for (int i = 0; i <= m; i++) {
17            result = 1 + result * base;
18        }
19        return result;
20    }
21}