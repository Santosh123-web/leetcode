// Last updated: 9/21/2026, 10:13:01 PM
1// Add 1 at both ends so that every balloon always has a left and right boundary.
2
3// Instead of thinking about which balloon to burst FIRST,
4// think about which balloon is burst LAST inside the interval [l, r].
5
6// If i is the LAST balloon burst between l and r,
7// then every balloon between l and i is already gone,
8// and every balloon between i and r is already gone.
9
10// Therefore, when i is finally burst,
11// its only remaining neighbors are l and r.
12
13// So the coins gained by bursting i last are:
14// arr[l] * arr[i] * arr[r]
15
16// The balloons on the left and right are independent subproblems:
17// dfs(l, i) -> maximum coins from balloons between l and i
18// dfs(i, r) -> maximum coins from balloons between i and r
19
20// Therefore:
21// total = left subproblem
22//       + coins from bursting i last
23//       + right subproblem
24
25// Try every possible i as the last balloon,
26// and take the maximum.
27
28// dp[l][r] stores the maximum coins obtainable
29// by bursting all balloons strictly between l and r.
30
31// We use memoization because the same interval [l, r]
32// can be reached through many different choices of i.
33
34// Base case:
35// If there is no balloon between l and r,
36// there is nothing to burst, so the result is 0.
37
38// The boundary balloons l and r are NOT burst by dfs(l, r).
39// They are kept alive specifically so they can act as
40// the left and right neighbors when the last balloon is burst.
41
42// There is no need for special cases like l == 0 && r == 0.
43// The condition l + 1 == r already represents an empty interval.
44class Solution {
45    Integer dp[][];
46    public int maxCoins(int[] nums) {
47        int n = nums.length;
48
49        dp = new Integer[n+2][n+2];
50
51        int arr[] = new int[n+2];
52        arr[0] = 1;
53        arr[n+1] = 1;
54        for(int i=0;i<n;i++)
55            arr[i+1] = nums[i];
56        
57        return dfs(arr,n,0,n+1);
58    }
59
60    private int dfs(int arr[],int n,int l,int r){        
61        if(l == 0 && r == 0)
62            return 1;
63        
64        if(l == n+1 && r == n+1)
65            return 1;
66        
67        if(dp[l][r] != null)
68            return dp[l][r];
69
70        dp[l][r] = 0;
71        for(int i=l+1;i<r;i++){
72            int sum = dfs(arr,n,l,i) + (arr[l] * arr[i] * arr[r]) + dfs(arr,n,i,r);
73
74            dp[l][r] = Math.max(dp[l][r],sum);
75        }
76
77        return dp[l][r];
78    }
79
80}