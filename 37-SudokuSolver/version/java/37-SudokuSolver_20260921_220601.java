// Last updated: 9/21/2026, 10:06:01 PM
1class Solution {
2    public int calculate(String s) {
3        int number = 0;
4        int signValue = 1;
5        int result = 0;
6        Stack<Integer> operationsStack = new Stack<>();
7
8        for (int i = 0; i < s.length(); i++) {
9            char c = s.charAt(i);
10
11            if (Character.isDigit(c)) {
12                number = number * 10 + (c - '0');
13            } else if (c == '+' || c == '-') {
14                result += number * signValue;
15                signValue = (c == '-') ? -1 : 1;
16                number = 0;
17            } else if (c == '(') {
18                operationsStack.push(result);
19                operationsStack.push(signValue);
20                result = 0;
21                signValue = 1;
22            } else if (c == ')') {
23                result += signValue * number;
24                result *= operationsStack.pop();
25                result += operationsStack.pop();
26                number = 0;
27            }
28        }
29
30        return result + number * signValue;
31    }
32}