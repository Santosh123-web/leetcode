// Last updated: 9/24/2026, 9:19:29 PM
1class Solution {
2    
3    public int strongPasswordChecker(String password) {
4        // Convert the password string to a character array for easy iteration.
5        char[] c = password.toCharArray();
6        int n = c.length;
7
8        // Initialize requirements based on password length.
9        int addreq = 0; // Required additions to meet minimum length.
10        int delreq = 0; // Required deletions to meet maximum length.
11        int fillme = 0; // Requirements for missing types of characters (digits, uppercase, lowercase).
12        int nut = 0; // Tracks number of modifications made to reduce repeated sequences.
13
14        // Set requirements based on the current length of the password.
15        if (n < 6) addreq = 6 - n;
16        if (n > 20) delreq = n - 20;
17        
18        // Temporary character to store the last processed character.
19        char temp = '@';
20
21        // Flags to check presence of digit, uppercase and lowercase characters.
22        boolean digitp = false;
23        boolean upperp = false;
24        boolean lowerp = false;
25
26        int np = 0; // Current sequence length.
27        int repchel = 0; // Unused variable, can be removed.
28
29        // Priority queue to store lengths of sequences where characters repeat.
30        // It sorts primarily by the sequence length modulo 3, to optimize the number of deletions required.
31        Queue<Integer> delqueue = new PriorityQueue<>((a, b) -> a % 3 - b % 3);
32
33        // Iterate through the password to detect character sequences and character types.
34        for (char ch : c) {
35            if (ch == temp) {
36                np++;
37            } else {
38                if (np >= 3) {
39                    delqueue.offer(np);
40                }
41                np = 1;
42                temp = ch;
43            }
44
45            // Check and update the presence of digit, uppercase, and lowercase.
46            if (!digitp && Character.isDigit(ch)) digitp = true;
47            if (!upperp && Character.isUpperCase(ch)) upperp = true;
48            if (!lowerp && Character.isLowerCase(ch)) lowerp = true;
49        }
50
51        // Offer the last sequence to the queue if it's a repeating sequence.
52        if (np >= 3) {
53            delqueue.offer(np);
54        }
55        
56        // Increment `fillme` for each missing character type.
57        if (!digitp) fillme++;
58        if (!upperp) fillme++;
59        if (!lowerp) fillme++;
60
61        // Process deletions from sequences to try to meet the max length requirement.
62        while (delreq > 0 && !delqueue.isEmpty()) {
63            int l = delqueue.peek();
64            int tobedeleted = l % 3 + 1;
65            if (tobedeleted > delreq) break;
66            else {
67                delreq -= tobedeleted;
68                l -= tobedeleted;
69                delqueue.poll();
70                nut += tobedeleted;
71                if (l >= 3) delqueue.offer(l);
72            }
73        }
74
75        // Calculate the total replacement required for leftover sequences.
76        int repreq = 0;
77        while (!delqueue.isEmpty()) {
78            repreq += delqueue.poll() / 3;
79        }
80
81        // The total number of operations needed is the sum of deletions, max of additions/replacements, and filling missing character types.
82        return nut + delreq + Math.max(fillme, Math.max(addreq, repreq));
83    }
84}