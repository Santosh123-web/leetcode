// Last updated: 9/24/2026, 9:53:24 PM
1class Solution {
2
3    public class LazyHeap{
4        int size=0;
5        PriorityQueue<Integer> heap;
6        Map<Integer,Integer> removed;
7        public LazyHeap(Comparator<Integer> c){
8            heap=new PriorityQueue<>(c);
9            removed=new HashMap<>();
10        }
11        public int size(){return size;}
12        public int poll(){
13            int v=peek();
14            remove(v);
15            return v;
16        }
17        public int peek(){
18            while(removed.getOrDefault(heap.peek(),0)>0){
19                int r=heap.poll();
20                removed.put(r,removed.get(r)-1);
21            }
22            return heap.peek();
23        }
24        public void add(int num){
25            size++;
26            heap.add(num);
27        }
28        public void remove(int num){
29            size--;
30            removed.put(num,removed.getOrDefault(num,0)+1);
31        }
32        
33    }
34
35
36    //PriorityQueue<Integer> minHeap=new PriorityQueue<>();//high vals
37    //PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());//low vals
38    LazyHeap minHeap=new LazyHeap(Comparator.naturalOrder());
39    LazyHeap maxHeap=new LazyHeap(Collections.reverseOrder());
40    int k,n;
41
42
43
44    public double[] medianSlidingWindow(int[] nums, int k) {
45        n=nums.length;
46        this.k=k;
47        double[] ans=new double[n-k+1];
48
49        /*add inital to heap*/
50        int left=0;
51        int right=0;
52        //grow window until full
53        while(right<k){
54            add(nums[right++]);
55        }
56        ans[left++]=median();
57
58        //for each window
59        while(left<n-k+1){
60            //  add new
61            // remove old
62            // calc median
63            remove(nums[left-1]);
64            add(nums[right++]);
65            ans[left++]=median();
66        }
67        
68        return ans;
69    }
70    public void add(int num){
71        minHeap.add(num);
72        if(minHeap.size()>maxHeap.size()){
73            maxHeap.add(minHeap.poll());
74        }
75        balance();
76    }
77    public void remove(int num){
78        if(num<minHeap.peek()){
79            maxHeap.remove(num);
80        }else{
81            minHeap.remove(num);
82        }
83        balance();
84    }
85    public void balance(){
86        while(minHeap.size()>maxHeap.size()+1){
87            maxHeap.add(minHeap.poll());
88        }
89        while(maxHeap.size()>minHeap.size()){
90            minHeap.add(maxHeap.poll());
91        }
92    }
93    public double median(){
94        return k%2==1?minHeap.peek():((double)minHeap.peek()+(double)maxHeap.peek())/2.0;
95    }
96}