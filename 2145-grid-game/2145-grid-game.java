class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long firstSum = 0;
        for(int i=0; i<n; i++){
            firstSum += grid[0][i];
        }

        long secondSum = 0;
        long ans = Long.MAX_VALUE;
        for(int i=0; i<n; i++){
            firstSum -= grid[0][i];
            ans = Math.min(ans, Math.max(firstSum, secondSum));
            secondSum += grid[1][i];
        }
        
        return ans;
    }
}