class Solution {
    public long coloredCells(int n) {
        long ans = 1L;
        for(int i=0; i<n-1; i++){
            ans += 4*(i+1);
        }
        return ans;
    }
}