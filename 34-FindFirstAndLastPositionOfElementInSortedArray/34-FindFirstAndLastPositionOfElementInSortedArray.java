// Last updated: 7/16/2026, 4:10:55 PM
class Solution {
    public int[] searchRange(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {

                if (i + 1 < nums.length && nums[i + 1] == target) {
                    int j = i;

                    while (j + 1 < nums.length &&
                           nums[j + 1] == target) {
                        j++;
                    }

                    return new int[]{i, j};
                }

                return new int[]{i, i};
            }
        }

        return new int[]{-1, -1};
    }
}