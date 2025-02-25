class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = (int) Math.pow(10, 9) + 7;
        int n = arr.length;

        for(int i=0; i<n; i++){
            arr[i] %= 2;
        }
        int[] even = new int[n];
        int[] odd = new int[n];
        if(arr[n-1] == 0){
            even[n-1] = 1;
        }else{
            odd[n-1] = 1;
        }

        for(int i=n-2; i >= 0; i--){
            if(arr[i] == 1){
                odd[i] = (1 + even[i + 1]) % mod;
                even[i] = odd[i+1];
            }else{
                even[i] = (1 + even[i+1]) % mod;
                odd[i] = odd[i+1];
            }
        }

        int count = 0;
        for(int odds : odd){
            count += odds;
            count %= mod;
        }
        return count;
    }
}