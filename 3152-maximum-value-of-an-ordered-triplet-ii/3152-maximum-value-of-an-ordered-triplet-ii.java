class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long ans = 0L;
        long dmax = 0;
        long imax = 0;
        for(int i=0; i<n; i++){
            ans = Math.max(ans, dmax * nums[i]);
            dmax = Math.max(dmax, imax - nums[i]);
            imax = Math.max(imax, nums[i]);
        }
        return ans;
    }
}