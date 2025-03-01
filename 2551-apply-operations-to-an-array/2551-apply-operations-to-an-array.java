class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for(int i=0; i<n-1; i++){
            if(nums[i] == nums[i+1]){
                nums[i] *= 2;
                nums[i+1] = 0;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == 0){
                count++;
            }else{
                q.add(nums[i]);
            }
        }
        int idx = 0;
        while(!q.isEmpty()){
            ans[idx++] = q.poll();
        }

        for(int i=0; i<count; i++){
            ans[idx] = 0;
        }
        return ans;
    }
}