// Last updated: 9/24/2026, 9:02:40 PM
1class Solution {
2    public int countRangeSum(int[] nums, int lower, int upper) {
3        int n=nums.length;
4        long [] sum=new long[n+1];
5        for(int i=0;i<n;i++){
6            sum[i+1]=sum[i]+nums[i];
7        }return mergeSort(sum,0,n,lower,upper);
8    }
9    private int mergeSort(long[] sum, int low, int high, int lower, int upper){
10        if (low>= high){
11            return 0;
12        }int mid=(high+1-low)/2+low;
13        int count=mergeSort(sum,low,mid-1,lower,upper)+ mergeSort(sum,mid,high,lower,upper);
14        int start_index=mid;
15        int end_index=mid;
16        for(int i=low;i<mid;i++){
17            while(start_index<=high && sum[start_index]-sum[i]<lower){
18                start_index++;
19            }while(end_index<=high && sum[end_index]-sum[i]<=upper){
20                end_index++;
21            }count+= end_index-start_index;
22        }merge(sum,low,mid-1,mid,high);
23        return count;
24    }
25    private void merge(long[] sum, int low1, int high1, int low2, int high2){
26        long[] helper= new long[high2-low1+1];
27        int index=0;
28        int index1=low1; int index2= low2;
29        while(index1<=high1 && index2<=high2){
30            if(sum[index1]<=sum[index2]){
31                helper[index++]=sum[index1++];
32            }else{
33                helper[index++]=sum[index2++];
34            }
35        }while(index1<=high1){
36            helper[index++]=sum[index1++];
37        }while(index2<=high2){
38            helper[index++]=sum[index2++];
39        }
40        System.arraycopy(helper,0,sum,low1,high2-low1+1);
41    }
42}