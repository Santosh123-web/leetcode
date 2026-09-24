// Last updated: 9/24/2026, 9:57:51 PM
1class Solution {
2    public int reversePairs(int[] nums) {
3        return mergeSort(nums, 0, nums.length - 1);
4    }
5
6    private int mergeSort(int[] nums, int left, int right) {
7        if (left >= right) return 0;
8
9        int mid = (left + right) / 2;
10        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
11
12        // Count reverse pairs across halves
13        int j = mid + 1;
14        for (int i = left; i <= mid; i++) {
15            while (j <= right && (long) nums[i] > 2L * nums[j]) {
16                j++;
17            }
18            count += (j - (mid + 1));
19        }
20
21        // Merge step
22        merge(nums, left, mid, right);
23        return count;
24    }
25
26    private void merge(int[] nums, int left, int mid, int right) {
27        int[] temp = new int[right - left + 1];
28        int i = left, j = mid + 1, k = 0;
29
30        while (i <= mid && j <= right) {
31            if (nums[i] <= nums[j]) temp[k++] = nums[i++];
32            else temp[k++] = nums[j++];
33        }
34        while (i <= mid) temp[k++] = nums[i++];
35        while (j <= right) temp[k++] = nums[j++];
36
37        System.arraycopy(temp, 0, nums, left, temp.length);
38    }
39}