// Last updated: 9/21/2026, 10:15:39 PM
1class Solution {
2    int [] lexicoLargest(int []nums , int k){
3        int n=nums.length;
4        int []stack= new int [n];
5        k= Math.min(n , k);
6        int top=-1;
7        int rem= n-k;
8        for(int num : nums){
9            while(top>=0 && rem>0 && stack[top]<num){
10                top--;
11                rem--;
12            }
13            stack[++top]=num;
14        }
15        return Arrays.copyOfRange(stack , 0 , k);
16    }
17    int []merge(int []nums1 , int []nums2){
18        if(nums1.length==0)return nums2;
19        if(nums2.length==0)return nums1;
20        int len = nums1.length+ nums2.length;
21        int []merged = new int [len];
22        int i=0;
23        int j=0;
24        int idx=0;
25        while(i<nums1.length && j<nums2.length){
26            if(nums1[i]>nums2[j]){
27             merged[idx]=nums1[i];
28             i++; idx++;
29            }
30            else if(nums1[i]<nums2[j]){
31                merged[idx]=nums2[j];
32                j++; idx++;
33            }
34            else {
35                if(check(nums1, nums2, i , j)){
36                     merged[idx]=nums1[i];
37                     i++; idx++;
38                }
39                else{
40                    merged[idx]=nums2[j];
41                     j++; idx++;
42                }
43            }
44        }
45        while(i<nums1.length){
46            merged[idx]=nums1[i];
47            idx++; i++;
48        }
49        while(j<nums2.length){
50            merged[idx]=nums2[j];
51            idx++; j++;
52        }
53        return merged;
54    }
55    // this check function return true if nums1 is lexico larger or equal else return false
56    boolean check(int []nums1 , int []nums2 , int idx1 , int idx2){
57        while(idx1<nums1.length || idx2<nums2.length){
58            if(idx1>=nums1.length)return false;
59            else if(idx2>=nums2.length)return true;
60            else if(nums1[idx1]>nums2[idx2])return true;
61            else if(nums2[idx2]>nums1[idx1])return false;
62            else{
63                idx1++;
64                idx2++;
65            }
66        }
67        return true;
68    }
69    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
70        int n1=nums1.length;
71        int n2=nums2.length;
72        // try all possible combination of k 
73        // 0 number from nums1, k numbers from nums2
74        // 1 number from nums1, k-1 numbers from nums2
75        int []ans = new int [k];
76        for(int i=0;i<=k;i++){
77            if(nums1.length<i || nums2.length<k-i)continue;
78           int []first= lexicoLargest(nums1 , i);
79           int []sec= lexicoLargest(nums2 , k-i);
80           int []merged = merge(first , sec);
81           if(check(merged , ans, 0 , 0 )){
82             ans = merged;
83           }
84        }
85        return ans;
86    }
87}