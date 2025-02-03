class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ans = 1;
        int count = 1;
        int n = nums.length;
        for(int i=0; i<n-1; i++){
            if(nums[i] < nums[i+1]){
                count++;
            }else{
                count = 1;
            }
            ans = Math.max(ans, count);
        }
        count = 1;
        for(int i=0; i<n-1; i++){
            if(nums[i] > nums[i+1]){
                count++;
            }else{
                count = 1;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}