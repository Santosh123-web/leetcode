// Last updated: 8/6/2026, 9:08:10 AM
1class Solution {
2    public void nextPermutation(int[] nums) {
3        int ind1=-1;
4        int ind2=-1;
5        // step 1 find breaking point 
6        for(int i=nums.length-2;i>=0;i--){
7            if(nums[i]<nums[i+1]){
8                ind1=i;
9                break;
10            }
11        }
12        // if there is no breaking  point 
13        if(ind1==-1){
14            reverse(nums,0);
15        }
16        
17        else{
18            // step 2 find next greater element and swap with ind2
19            for(int i=nums.length-1;i>=0;i--){
20                if(nums[i]>nums[ind1]){
21                    ind2=i;
22                    break;
23                }
24            }
25
26            swap(nums,ind1,ind2);
27            // step 3 reverse the rest right half
28            reverse(nums,ind1+1);
29        }
30    }
31    void swap(int[] nums,int i,int j){
32        int temp=nums[i];
33        nums[i]=nums[j];
34        nums[j]=temp;
35    }
36    void reverse(int[] nums,int start){
37        int i=start;
38        int j=nums.length-1;
39        while(i<j){
40            swap(nums,i,j);
41            i++;
42            j--;
43        }
44    }
45}