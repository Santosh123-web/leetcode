// Last updated: 9/24/2026, 9:04:54 PM
1class Solution {
2
3    Map<String, PriorityQueue<String>> map = new HashMap<>();
4    LinkedList<String> result = new LinkedList<>();
5
6    public List<String> findItinerary(List<List<String>> tickets) {
7
8        for (List<String> t : tickets) {
9            map.putIfAbsent(t.get(0), new PriorityQueue<>());
10            map.get(t.get(0)).add(t.get(1));
11        }
12
13        dfs("JFK");
14
15        return result;
16    }
17
18    public void dfs(String airport) {
19
20        PriorityQueue<String> pq = map.get(airport);
21
22        while (pq != null && !pq.isEmpty()) {
23            String next = pq.poll();
24            dfs(next);
25        }
26
27        result.addFirst(airport);
28    }
29}