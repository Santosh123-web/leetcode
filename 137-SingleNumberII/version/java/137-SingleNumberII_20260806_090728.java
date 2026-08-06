// Last updated: 8/6/2026, 9:07:28 AM
1class Solution {
2    public int singleNumber(int[] nums) {
3        Map<Integer, Integer> map = new HashMap<>();
4        
5        for (int x : nums) {
6            map.put(x, map.getOrDefault(x, 0) + 1);
7        }
8
9        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
10            if (entry.getValue() == 1) {
11                return entry.getKey();
12            }
13        }
14        
15        return -1;
16    }
17}