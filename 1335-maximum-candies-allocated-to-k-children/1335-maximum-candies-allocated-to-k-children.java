class Solution {
    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;
        int right = 0;
        for(int i=0; i<n; i++){
            right = Math.max(right, candies[i]);
        }
        
        int left = 1;
        int ans = 0;
        while(left <= right){
            int mid = (left + right) / 2;
            long count = 0;
            for(int i=0; i<n; i++){
                count += (candies[i] / mid);
            }

            if(count >= k){
                left = mid + 1;
                ans = Math.max(mid, ans);
            }else{
                right = mid-1;
            }
        }
        return ans;
    }
}
