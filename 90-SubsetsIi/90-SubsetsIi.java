// Last updated: 7/16/2026, 4:09:06 PM
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, nums, subset, res);
        return res;        
    }

    private void backtrack(int i, int[] nums, List<Integer> subset, List<List<Integer>> res) {
        if (i == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        backtrack(i + 1, nums, subset, res);
        subset.remove(subset.size() - 1);

        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }

        backtrack(i + 1, nums, subset, res);
    }    
}