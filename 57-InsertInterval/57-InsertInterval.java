// Last updated: 7/16/2026, 4:10:21 PM
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int start = newInterval[0];
        int end = newInterval[1];

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (intervals[i][1] < start) {
                // Interval is completely before newInterval
                list.add(intervals[i]);
            } else if (intervals[i][0] > end) {
                // Interval is completely after newInterval
                if (start != -1) {
                    list.add(new int[]{start, end});
                    start = -1; // Mark as inserted
                }
                list.add(intervals[i]);
            } else {
                // Overlapping intervals, merge them
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            }
        }

        // Add merged interval if not inserted yet
        if (start != -1) {
            list.add(new int[]{start, end});
        }

        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}