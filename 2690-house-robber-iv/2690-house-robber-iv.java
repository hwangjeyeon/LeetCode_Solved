class Solution {
    public int minCapability(int[] nums, int k) {
        int min = 1;
        int max = 1;
        for(int i=0; i<nums.length; i++){
            max = Math.max(nums[i], max);
        }
        int ans = Integer.MAX_VALUE;
        while(min <= max){
            int mid = (min + max) / 2;
            int pos = 0;
            for(int i=0; i< nums.length; i++){
                if(nums[i] <= mid){
                    pos++;
                    i++;
                }
            }
            if(pos >= k){
                max = mid-1;
                ans = Math.min(ans, mid);
            }else{
                min = mid + 1;
            }

        }
        return ans;
    }
}