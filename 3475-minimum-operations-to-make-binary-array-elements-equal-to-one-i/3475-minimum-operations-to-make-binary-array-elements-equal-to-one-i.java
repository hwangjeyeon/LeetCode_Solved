class Solution {
    public int minOperations(int[] nums) {
        int count = 0;
        int n = nums.length;
        for(int i=0; i< n-2; i++){
            if(nums[i] == 0){
                nums[i] = 1;
                nums[i+1] = nums[i+1] == 0 ? 1 : 0;
                nums[i+2] = nums[i+2] == 0 ? 1 : 0;
                count++;
            }
        }
        if(nums[n-2] ==0 || nums[n-1] == 0){
            return -1;
        }
        return count;
    }
}