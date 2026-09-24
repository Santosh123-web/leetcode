// Last updated: 9/24/2026, 10:07:24 PM
1class Solution {
2    public int singleNonDuplicate(int[] nums) {
3        // [1,1,2,3,3,4,4,8,8]
4        // O(logn)
5        //O(1)
6        int n=nums.length;
7        int s=0;int e=n-1;
8        while(s<e){
9            int mid=s+(e-s)/2;
10            // Make mid even
11            if (mid % 2 == 1) {
12                mid--;
13            }
14
15            if(nums[mid] ==nums[mid+1]){
16                s=mid+2;
17            }else{
18                e=mid;
19            }
20        }
21        return nums[s];
22    }
23    
24}