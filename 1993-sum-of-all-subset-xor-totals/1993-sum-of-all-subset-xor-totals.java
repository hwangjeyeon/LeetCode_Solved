class Solution {
    public int subsetXORSum(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        backtracking(nums, 0, new ArrayList<>(), subsets);
        int ans = 0;
        for(List<Integer> subset : subsets){
            int total = 0;
            for(int num: subset){
                total ^= num;
            }
            ans += total;
        }
        return ans;
    }
    private static void backtracking(int[] nums, int idx, List<Integer> subset,
    List<List<Integer>> subsets){
        if(idx == nums.length){
            subsets.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[idx]);
        backtracking(nums, idx+1, subset, subsets);
        subset.remove(subset.size()-1);

        backtracking(nums, idx+1, subset, subsets);
    }
}