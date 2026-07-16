// Last updated: 7/16/2026, 4:08:29 PM
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }

        return ans;
    }
}