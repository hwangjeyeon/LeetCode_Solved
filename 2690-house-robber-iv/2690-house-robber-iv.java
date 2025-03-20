class Solution {
    public int minCapability(int[] nums, int k) {
        int left = 1;
        int right = 1;
        for(int i=0; i<nums.length; i++){
            right = Math.max(right, nums[i]);
        }

        int ans = Integer.MAX_VALUE;
        while(left <= right){
            int mid = (left + right) / 2;
            int count = 0;
            for(int i=0; i<nums.length; i++){
                if(nums[i] <= mid){
                    count++;
                    i++;
                }
            }
            if(count >= k){
                right = mid - 1;
                ans = Math.min(ans, mid);
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }
}