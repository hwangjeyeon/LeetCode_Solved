class Solution {
    public int longestNiceSubarray(int[] nums) {
        int max = 1;
        for(int i=0; i < nums.length - max; i++){
            int cur = 1;
            int bit = nums[i];
            for(int j=i+1; j < nums.length; j++){
                if((bit & nums[j]) == 0){
                    bit |= nums[j];
                    cur++;
                }else{
                    break;
                }
            }
            max = Math.max(max, cur);
        }

        return max;
    }
}