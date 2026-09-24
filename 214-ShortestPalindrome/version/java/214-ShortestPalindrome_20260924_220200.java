// Last updated: 9/24/2026, 10:02:00 PM
1class Solution {
2    public int findLUSlength(String a, String b) {
3        if (a.equals(b))
4            return -1;
5        return Math.max(a.length(), b.length());
6    }
7}