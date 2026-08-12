// Last updated: 8/12/2026, 11:17:39 AM
1class Solution {
2    int n;
3    boolean[][] is_palindrome;
4    String[][] substrings;
5
6    List<List<String>> ans;
7
8    void FindSubstrings(int ind, ArrayList<String> list) {
9        if (ind == n) {
10            ans.add(new ArrayList<String>(list));
11            return;
12        }
13
14        for (int i = ind + 1; i <= n; i++) {
15            if (!is_palindrome[ind][i]) continue;
16            list.add(substrings[ind][i]);
17            FindSubstrings(i, list);
18            list.remove(list.size() - 1);
19        }
20    }
21
22    public List<List<String>> partition(String s) {
23        n = s.length();
24        is_palindrome = new boolean[n + 1][n + 1];
25        substrings = new String[n + 1][n + 1];
26        for (int i = 0; i < n; i++) for (int j = i + 1; j <= n; j++) {
27            substrings[i][j] = s.substring(i, j);
28            is_palindrome[i][j] = IsPalindrome(substrings[i][j]);
29        }
30
31        ans = new ArrayList<List<String>>();
32        FindSubstrings(0, new ArrayList<String>());
33        return ans;
34    }
35
36    boolean IsPalindrome(String s) {
37        int lower = 0;
38        int higher = s.length() - 1;
39        while (lower < higher) {
40            if (s.charAt(lower) != s.charAt(higher)) return false;
41            lower++;
42            higher--;
43        }
44        return true;
45    }
46}