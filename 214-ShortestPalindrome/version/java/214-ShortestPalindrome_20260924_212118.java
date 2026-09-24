// Last updated: 9/24/2026, 9:21:18 PM
1public class Solution {
2    public int numberOfArithmeticSlices(int[] nums) {
3        int n = nums.length;
4        int total_count = 0;
5
6        HashMap<Integer, Integer>[] dp = new HashMap[n];
7
8        for (int i = 0; i < n; ++i) {
9            dp[i] = new HashMap<>();
10        }
11
12        for (int i = 1; i < n; ++i) {
13            for (int j = 0; j < i; ++j) {
14                long diff = (long) nums[i] - nums[j]; 
15
16                if (diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE) {
17                    continue; 
18                }
19
20                int diffInt = (int) diff;
21
22                dp[i].put(diffInt, dp[i].getOrDefault(diffInt, 0) + 1);  
23                if (dp[j].containsKey(diffInt)) {
24                    dp[i].put(diffInt, dp[i].get(diffInt) + dp[j].get(diffInt));
25                    total_count += dp[j].get(diffInt);
26                }
27            }
28        }
29
30        return total_count;
31    }
32}