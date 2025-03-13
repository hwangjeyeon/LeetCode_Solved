class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length; 
        int left = 0;
        int right = queries.length;
        if(!check(nums, queries, right)){
            return -1;
        }
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(check(nums, queries, mid)){
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean check(int[] nums, int[][] queries, int k){
        int n = nums.length;
        int sum = 0;
        int[] diff = new int[n+1];

        for(int i=0; i<k; i++){
            int left = queries[i][0];
            int right = queries[i][1];
            int val = queries[i][2];

            diff[left] += val;
            diff[right + 1] -= val;
        }
        for(int i=0; i<n; i++){
            sum += diff[i];
            if(sum < nums[i]){
                return false;
            }
        }
        return true;
    }
}