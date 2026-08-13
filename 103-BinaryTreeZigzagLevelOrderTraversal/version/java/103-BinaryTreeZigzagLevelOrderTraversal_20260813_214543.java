// Last updated: 8/13/2026, 9:45:43 PM
1class Solution {
2    public int evalRPN(String[] tokens) {
3        int[] stack = new int[tokens.length];
4        int top = -1; // Pointer to the top of our simulated stack
5
6        for (String s : tokens) {
7            switch (s) {
8                // For operators, we combine the top two elements and shrink the stack pointer by 1
9                case "+" -> { stack[top - 1] += stack[top]; top--; }
10                case "-" -> { stack[top - 1] -= stack[top]; top--; }
11                case "*" -> { stack[top - 1] *= stack[top]; top--; }
12                case "/" -> { stack[top - 1] /= stack[top]; top--; }
13                
14                // For numbers, we expand the stack pointer and insert the number
15                default  -> stack[++top] = Integer.parseInt(s);
16            }
17        }
18
19        // The final result will be the only item left, sitting at index 0
20        return stack[0];
21    }
22}