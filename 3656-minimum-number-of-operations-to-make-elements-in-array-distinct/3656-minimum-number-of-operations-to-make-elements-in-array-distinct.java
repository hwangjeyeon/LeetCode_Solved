class Solution {
    public int minimumOperations(int[] nums) {
        boolean[] chk = new boolean[128];
        for(int i=nums.length-1; i>=0; i--){
            if(chk[nums[i]]){
                return i / 3 + 1;
            }
            chk[nums[i]] = true;
        }
        return 0;
    }
}