class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            int x = 0;
            for(int j=i; j<n; j++){
                arr[x++] = nums[j];
            }
            for(int j=0; j<i; j++){
                arr[x++] = nums[j];
            }
            boolean isOk = true;
            for(int j=0; j<n-1; j++){
                if(arr[j] > arr[j+1]){
                    isOk = false;
                    break;
                }
            }
            if(isOk){
                return true;
            }
        }
        
        return false;
    }
}