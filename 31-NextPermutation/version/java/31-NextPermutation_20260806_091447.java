// Last updated: 8/6/2026, 9:14:47 AM
1import java.util.*;
2
3class Solution {
4    public List<String> restoreIpAddresses(String s) {
5        List<String> result = new ArrayList<>();
6        backtrack(s, 0, 0, "", result);
7        return result;
8    }
9
10    private void backtrack(String s, int index, int parts, String current, List<String> result) {
11        // If we got 4 parts and used all characters → valid IP
12        if (parts == 4 && index == s.length()) {
13            result.add(current.substring(0, current.length() - 1)); // remove last dot
14            return;
15        }
16
17        // If invalid state
18        if (parts > 4) return;
19
20        // Try 1 to 3 digit parts
21        for (int len = 1; len <= 3; len++) {
22            if (index + len > s.length()) break;
23
24            String part = s.substring(index, index + len);
25
26            // ❌ Skip invalid cases
27            if ((part.startsWith("0") && part.length() > 1) || Integer.parseInt(part) > 255) {
28                continue;
29            }
30
31            backtrack(s, index + len, parts + 1, current + part + ".", result);
32        }
33    }
34}