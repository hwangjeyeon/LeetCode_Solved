class Solution {
    public int longestNiceSubarray(int[] nums) {
        int bit = 0;
        int start = 0;
        int ans = 0;
        for(int i=0; i < nums.length; i++){
            while((bit & nums[i]) != 0){
                bit ^= nums[start];
                start++;
            }

            bit |= nums[i];
            ans = Math.max(ans, i - start + 1);
        }

        return ans;
    }
}