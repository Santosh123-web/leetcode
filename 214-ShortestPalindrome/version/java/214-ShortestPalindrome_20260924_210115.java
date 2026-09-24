// Last updated: 9/24/2026, 9:01:15 PM
1class Solution {
2        /*
3        #########################################################################
4        #                                                                       #
5        #  =============================================                        #
6        #                  SIDDARDHA CHILUVERU                                  #
7        #  =============================================                        #
8        #                                                                       #
9        #  Author      : Siddardha Chiluveru                                    #
10        #  Description : Solution / Code / Project                              #
11        #  Date        : 2026-08-10                                             #
12        #                                                                       #
13        #########################################################################
14        */
15    public int[] maxSlidingWindow(int[] nums, int k) {
16        TreeMap<Integer, Integer> map = new TreeMap<>();
17        for (int i = 0; i < k; i++)
18            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
19        int[] ans = new int[nums.length - k + 1];
20        ans[0] = map.lastKey();
21        int l = 0;
22        int r = k;
23        while (r != nums.length) {
24            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
25            if (map.get(nums[l]) > 1)
26                map.put(nums[l], map.get(nums[l]) - 1);
27            else
28                map.remove(nums[l]);
29            ans[l + 1] = map.lastKey();
30            l += 1;
31            r += 1;
32        }
33        return ans;
34    }
35}