class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(nums[i] < pivot){
                q.add(nums[i]);
            }
        }
        for(int i=0; i<n; i++){
            if(nums[i] == pivot){
                q.add(nums[i]);
            }
        }
        for(int i=0; i<n; i++){
            if(nums[i] > pivot){
                q.add(nums[i]);
            }
        }
        int[] ans = new int[n];
        int idx = 0;
        while(!q.isEmpty()){
            ans[idx++] = q.poll();
        }
        return ans;
    }
}