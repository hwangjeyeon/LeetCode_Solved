class Solution {
    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;
        int max = 0;
        for(int i=0; i<n; i++){
            max = Math.max(max, candies[i]);
        }
        int left = 0;
        int right = max;

        while(left < right){
            int mid = (left+ right + 1) / 2;
            if(check(candies, k, mid)){
                left= mid;
            }else{
                right = mid - 1;
            }
        }

        return left;
    }

    private static boolean check(int[] candies, long k, int num){
        long max= 0;
        for(int i=0; i<candies.length; i++){
            max += candies[i] / num;
        }
        return max >= k;
    }
}
