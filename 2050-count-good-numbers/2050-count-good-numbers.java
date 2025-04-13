class Solution {
    static long MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {
        return (int) ((recur(5, (n+1)/2) * recur(4, n/2))%MOD);
    }

    private long recur(int x, long y){
        long res = 1;
        long mul = x;
        while(y > 0){
            if(y%2 == 1){
                res = (res * mul) % MOD;
            }
            mul = (mul * mul) % MOD;
            y /= 2;
        }

        return res;
    }
}