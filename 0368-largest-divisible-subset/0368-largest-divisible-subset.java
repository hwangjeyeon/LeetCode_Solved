class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] pre = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(pre, -1);
        int max = 0;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[i] % nums[j] ==0 && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                    pre[i] = j;
                }
            }
            if(dp[i] > dp[max]){
                max = i;
            }
        }
        for(int i=max; i>=0; i = pre[i]){
            ans.add(nums[i]);
            if(pre[i] == -1){
                break;
            }
        }
        return ans;
    }
}