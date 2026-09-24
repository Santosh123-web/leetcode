// Last updated: 9/24/2026, 10:03:50 PM
1class Solution {
2    public int findPairs(int[] nums, int k) {
3        HashMap<Integer, Integer> mp = new HashMap<>();
4        for (int a : nums) {
5            mp.put(a, mp.getOrDefault(a, 0) + 1);
6        }
7        
8        int ans = 0;
9        for (Map.Entry<Integer, Integer> a : mp.entrySet()) {
10            if ((k > 0 && mp.containsKey(k + a.getKey())) || (k == 0 && a.getValue() > 1)) {
11                ans++;
12            }
13        }
14        return ans;
15    }
16}