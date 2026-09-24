// Last updated: 9/24/2026, 10:00:10 PM
1class Solution {
2
3    public boolean detectCapitalUse(String word) {
4
5        int upper = 0;
6
7        for (char ch : word.toCharArray()) {
8            if (Character.isUpperCase(ch)) {
9                upper++;
10            }
11        }
12
13        return upper == 0
14            || upper == word.length()
15            || (upper == 1 && Character.isUpperCase(word.charAt(0)));
16    }
17}