// Last updated: 9/24/2026, 9:18:35 PM
1class Solution {
2    public int splitArray(int[] nums, int k) {
3        int n = nums.length;
4        int max = -1;
5        int sum =0;
6
7        for(int i =0;i<n ;i++){
8            sum = sum + nums[i];
9            max = Math.max(max,nums[i]);
10        }
11
12        int low = max;
13        int high = sum;
14        int ans = -1;
15        while(low<=high){
16            int mid = (low+high)/2;
17            if(split(nums,n,mid,k)){
18                high = mid -1;
19                ans = mid;
20            }
21            else{
22                low = mid +1;
23            }
24        }
25        return ans;
26    }
27
28    public boolean split(int[] nums, int n , int maxsum , int maxsubarrcount) {
29        int subarr_count = 1;
30        int sum = 0;
31
32        for(int i=0;i<n ;i++){
33            if(nums[i]>maxsum) return false;
34            else if((nums[i]+sum) > maxsum){
35                // next subarray
36                subarr_count++;
37                sum = nums[i];
38            }
39            else{
40                sum = sum + nums[i];
41            }
42            if(subarr_count>maxsubarrcount)return false;
43        }
44        return true;
45    }
46}