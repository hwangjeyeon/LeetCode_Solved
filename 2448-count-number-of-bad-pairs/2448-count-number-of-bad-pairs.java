class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long ans = 0;
        Map<Integer, Integer> diff = new HashMap<>();
        for(int i = 0; i<n; i++){
            int diffs = i - nums[i];
            int good = diff.getOrDefault(diffs, 0);
            ans += i - good;
            diff.put(diffs, good + 1);
        }

        return ans;
    }
}