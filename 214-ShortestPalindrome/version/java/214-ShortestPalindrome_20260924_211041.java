// Last updated: 9/24/2026, 9:10:41 PM
1class Solution {
2    public int binarySearch(int[] dp, int val){
3        int lo=0,hi=dp.length-1,res=0;
4        while(lo<=hi){
5            int mid=(lo+hi)/2;
6            if(dp[mid]<val){
7                res=mid;
8                lo=mid+1;
9            }else{
10                hi=mid-1;
11            }
12        }
13        return res+1;
14    }
15    public int maxEnvelopes(int[][] envelopes) {
16        Arrays.sort(envelopes,(a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
17        int[] LIS=new int[envelopes.length+1];
18        Arrays.fill(LIS,Integer.MAX_VALUE);
19        LIS[0]=Integer.MIN_VALUE;
20        int ans=0;
21        for(int i=0;i<envelopes.length;i++){
22            int val=envelopes[i][1];
23            int insertIndex=binarySearch(LIS,val);
24            ans=Math.max(ans,insertIndex);
25            if(LIS[insertIndex]>=val){
26                LIS[insertIndex]=val;
27            }
28        }
29        return ans;
30    }
31}