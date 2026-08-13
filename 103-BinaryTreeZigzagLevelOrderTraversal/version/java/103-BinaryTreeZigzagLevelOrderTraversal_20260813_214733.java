// Last updated: 8/13/2026, 9:47:33 PM
1class MinStack {
2    private List<int[]> st;
3
4    public MinStack() {
5        st = new ArrayList<>();
6    }
7    
8    public void push(int val) {
9        int[] top = st.isEmpty() ? new int[]{val, val} : st.get(st.size() - 1);
10        int min_val = top[1];
11        if (min_val > val) {
12            min_val = val;
13        }
14        st.add(new int[]{val, min_val});        
15    }
16    
17    public void pop() {
18        st.remove(st.size() - 1);
19    }
20    
21    public int top() {
22        return st.isEmpty() ? -1 : st.get(st.size() - 1)[0];
23    }
24    
25    public int getMin() {
26        return st.isEmpty() ? -1 : st.get(st.size() - 1)[1];
27    }
28}