class Solution {
    public int minimumRecolors(String blocks, int k) {
        int[] arr = new int[blocks.length()];
        for(int i=0; i<blocks.length(); i++){
            if(blocks.charAt(i) == 'W'){
                arr[i] = 0;
            }else{
                arr[i] = 1;
            }
        }
        int n = arr.length;
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n-k+1; i++){
            int count = 0;
            for(int j=i; j<i+k; j++){
                if(arr[j] == 0){
                    count++;
                }
            }
            ans = Math.min(ans, count);
        }
        return ans;
    }
}