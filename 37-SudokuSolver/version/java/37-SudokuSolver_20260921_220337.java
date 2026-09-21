// Last updated: 9/21/2026, 10:03:37 PM
1class Solution {
2    private void addToList(List<List<Integer>> ans, List<Integer> tmp){
3        if(ans.isEmpty() || !ans.get(ans.size()-1).get(0).equals(tmp.get(0)))
4            ans.add(tmp);
5        else if (ans.get(ans.size()-1).get(1) < tmp.get(1))
6            ans.set(ans.size()-1, tmp);
7    }
8
9    private void handleEndEvt(PriorityQueue<int[]> endEvts, 
10            PriorityQueue<int[]> heights, List<List<Integer>> ans){
11        int[] endEvt = endEvts.poll();
12        while(!heights.isEmpty() && heights.peek()[1] <= endEvt[0])
13            heights.poll(); // remove already overlapped
14
15        if(!heights.isEmpty()){
16            if(heights.peek()[0] >= endEvt[1]) return;
17            else addToList(ans, List.of(endEvt[0], heights.peek()[0]));
18        } else addToList(ans, List.of(endEvt[0], 0));
19    }
20
21    public List<List<Integer>> getSkyline(int[][] A) {
22        List<List<Integer>> ans = new ArrayList<>();
23        PriorityQueue<int[]> endEvts 
24            = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
25        PriorityQueue<int[]> heights 
26            = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
27
28        for(int[] a: A){
29            // process endEvts before this building
30            while(!endEvts.isEmpty() && endEvts.peek()[0] < a[0])
31                handleEndEvt(endEvts, heights, ans);
32
33            // remove heights ended before this start
34            while(!heights.isEmpty() && heights.peek()[1] < a[0])
35                heights.poll();
36
37            // add starting if greater than current height
38            if(heights.isEmpty() || heights.peek()[0] < a[2]) 
39                addToList(ans, List.of(a[0], a[2]));
40
41            heights.offer(new int[]{a[2], a[1]}); // height, end_x
42            endEvts.offer(new int[]{a[1], a[2]}); // end_x, height
43        }
44
45        // process remaining endEvts 
46        while(!endEvts.isEmpty())
47            handleEndEvt(endEvts, heights, ans);
48
49        return ans;
50    }
51}