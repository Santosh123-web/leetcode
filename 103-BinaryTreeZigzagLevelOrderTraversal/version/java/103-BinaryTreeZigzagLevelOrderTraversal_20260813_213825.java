// Last updated: 8/13/2026, 9:38:25 PM
1class Solution {
2    public int maxProfit(int[] prices) {
3        int n = prices.length;
4        int[] minPrices = new int[n]; // minPrices[i] is min price from [0, i]
5        int[] maxProfits = new int[n]; // maxProfits[i] is max profit for first i (the i-th does not need to be used)
6        minPrices[0] = prices[0];
7        maxProfits[0] = 0;
8        for (int i = 1; i < n; i++) {
9            minPrices[i] = Math.min(minPrices[i - 1], prices[i]);
10            maxProfits[i] = maxProfits[i - 1];
11            if (prices[i] > minPrices[i - 1]) {
12                maxProfits[i] = Math.max(maxProfits[i], prices[i] - minPrices[i - 1]);
13            }
14        }
15
16        int ans = maxProfits[n - 1];
17        int maxPrice = prices[n - 1];
18        int maxProfit = 0;
19        // iterate n - 2 => 0, find max profit by using i and j (j > i), then plus max profits between [0, i - 1]
20        for (int i = n - 2; i > 0; i--) {
21            maxProfit = Math.max(maxPrice - prices[i], 0);
22            maxPrice = Math.max(maxPrice, prices[i]);
23            ans = Math.max(ans, maxProfit + maxProfits[i - 1]);
24        }
25        return ans;
26    }
27}