// Last updated: 9/21/2026, 10:02:44 PM
1class Solution {
2    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
3
4        TreeSet<Long> map = new TreeSet<>();
5        
6        for(int i=0; i<nums.length; i++){
7            long current = nums[i];
8
9            // To find smallest value >= current - valueDifff
10            Long value = map.ceiling(current - (long) valueDiff);
11            
12            // If value is also <= current + valueDiff, then a valid value exists
13            if (value != null && value <= current + (long) valueDiff) {
14                return true;
15            }
16
17            // Add current value to the sliding window
18            map.add(current);
19
20            if (i >= indexDiff) {
21                map.remove((long) nums[i - indexDiff]);
22            }   
23        }
24
25        return false;
26    }
27}