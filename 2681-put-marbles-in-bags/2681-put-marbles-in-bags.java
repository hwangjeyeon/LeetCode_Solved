class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        int[] pair = new int[n-1];
        for(int i=0; i< n-1; i++){
            pair[i] = weights[i] + weights[i+1];
        }
        Arrays.sort(pair, 0, n-1);
        long ans = 0L;
        for(int i=0; i<k-1; i++){
            ans += pair[n-2-i] - pair[i];
        }
        return ans;
    }
}