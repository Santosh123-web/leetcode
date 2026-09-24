// Last updated: 9/24/2026, 9:44:33 PM
1class Solution {
2    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
3        int base = minutesToTest / minutesToDie + 1;
4        int ans = 0;
5        long n = 1;
6
7        while (n < buckets) {
8            n *= base;
9            ans++;
10        }
11        return ans;
12    }
13}