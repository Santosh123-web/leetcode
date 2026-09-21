// Last updated: 9/21/2026, 10:12:01 PM
1public class Solution {
2    public List<String> removeInvalidParentheses(String s) {
3      List<String> res = new ArrayList<>();
4      
5      // sanity check
6      if (s == null) return res;
7      
8      Set<String> visited = new HashSet<>();
9      Queue<String> queue = new LinkedList<>();
10      
11      // initialize
12      queue.add(s);
13      visited.add(s);
14      
15      boolean found = false;
16      
17      while (!queue.isEmpty()) {
18        s = queue.poll();
19        
20        if (isValid(s)) {
21          // found an answer, add to the result
22          res.add(s);
23          found = true;
24        }
25      
26        if (found) continue;
27      
28        // generate all possible states
29        for (int i = 0; i < s.length(); i++) {
30          // we only try to remove left or right paren
31          if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;
32        
33          String t = s.substring(0, i) + s.substring(i + 1);
34        
35          if (!visited.contains(t)) {
36            // for each state, if it's not visited, add it to the queue
37            queue.add(t);
38            visited.add(t);
39          }
40        }
41      }
42      
43      return res;
44    }
45    
46    // helper function checks if string s contains valid parantheses
47    boolean isValid(String s) {
48      int count = 0;
49    
50      for (int i = 0; i < s.length(); i++) {
51        char c = s.charAt(i);
52        if (c == '(') count++;
53        if (c == ')' && count-- == 0) return false;
54      }
55    
56      return count == 0;
57    }
58}