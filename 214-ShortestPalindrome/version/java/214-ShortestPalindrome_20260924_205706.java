// Last updated: 9/24/2026, 8:57:06 PM
1class Solution {
2    public String shortestPalindrome(String s) {
3        int count = kmp(new StringBuilder(s).reverse().toString(), s);
4        return new StringBuilder(s.substring(count)).reverse().toString() + s;
5    }
6
7    private int kmp(String txt, String patt) {
8        String newString = patt + '#' + txt;
9        int[] pi = new int[newString.length()];
10        int i = 1, k = 0;
11        while (i < newString.length()) {
12            if (newString.charAt(i) == newString.charAt(k)) {
13                k++;
14                pi[i] = k;
15                i++;
16            } else {
17                if (k > 0) {
18                    k = pi[k - 1];
19                } else {
20                    pi[i] = 0;
21                    i++;
22                }
23            }
24        }
25        return pi[newString.length() - 1];
26    }
27}