// Last updated: 9/24/2026, 9:07:09 PM
1class Solution {
2    private boolean isPalindrome(String str) {
3        for (int i = 0; i < str.length() / 2; i++) {
4            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
5                return false;
6            }
7        }
8        return true;
9    }
10
11    public List<List<Integer>> palindromePairs(String[] words) {
12        List<List<Integer>> ans = new ArrayList<>();
13        Map<String, Integer> map = new HashMap<>();
14        
15        // Store reversed words with their indices
16        for (int i = 0; i < words.length; i++) {
17            String reversed = new StringBuilder(words[i]).reverse().toString();
18            map.put(reversed, i);
19        }
20
21        // Handle empty string case
22        if (map.containsKey("")) {
23            int emptyIdx = map.get("");
24            for (int i = 0; i < words.length; i++) {
25                if (!words[i].equals("") && isPalindrome(words[i])) {
26                    ans.add(Arrays.asList(i, emptyIdx));
27                }
28            }
29        }
30
31        // Check all splits of each word
32        for (int i = 0; i < words.length; i++) {
33            for (int j = 0; j < words[i].length(); j++) {
34                String left = words[i].substring(0, j + 1);
35                String right = words[i].substring(j + 1);
36
37                if (map.containsKey(left) && isPalindrome(right) && map.get(left) != i) {
38                    ans.add(Arrays.asList(i, map.get(left)));
39                }
40
41                if (map.containsKey(right) && isPalindrome(left) && map.get(right) != i) {
42                    ans.add(Arrays.asList(map.get(right), i));
43                }
44            }
45        }
46
47        return ans;
48    }
49}