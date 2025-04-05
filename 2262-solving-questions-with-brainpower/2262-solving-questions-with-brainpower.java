class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        for(int i=n-1; i>=0; i--){
            int idx = i + questions[i][1] + 1;
            if(idx < n){
                dp[i] = dp[idx] + questions[i][0]; 
            }else{
                dp[i] = questions[i][0];
            }
            if(i < n-1){
                dp[i] = Math.max(dp[i+1], dp[i]);
            }
        }
        return dp[0];
    }
}