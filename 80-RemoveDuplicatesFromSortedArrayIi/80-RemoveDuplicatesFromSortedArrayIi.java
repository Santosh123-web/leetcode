// Last updated: 7/16/2026, 4:09:33 PM
class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;        
    }
}