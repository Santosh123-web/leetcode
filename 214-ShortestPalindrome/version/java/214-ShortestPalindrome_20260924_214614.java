// Last updated: 9/24/2026, 9:46:14 PM
1class Solution {
2    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
3         int l1 = s1.length(), l2 = s2.length();
4        int[] next = new int[l2 + 1];
5        int[] count = new int[l2 + 1];
6        int cnt = 0, p = 0;
7        for (int i = 0; i < n1; i++) {
8            for (int j = 0; j < l1; j++) {
9                if (s1.charAt(j) == s2.charAt(p)) {
10                    p++;
11                }
12                if (p == l2) {
13                    cnt++;
14                    p = 0;
15                }
16            }
17            count[i] = cnt;
18            next[i] = p;
19            for (int j = 0; j < i; j++) {
20                if (next[j] == p) {
21                    int prev_count = count[j];
22                    int pattern_count = (count[i] - count[j]) * ((n1 - j - 1) / (i - j));
23                    int remain_count = count[j + (n1 - j - 1) % (i - j)] - count[j];
24                    return (prev_count + pattern_count + remain_count) / n2;
25                }
26            }
27        }
28        return count[n1 - 1] / n2;
29    }
30}