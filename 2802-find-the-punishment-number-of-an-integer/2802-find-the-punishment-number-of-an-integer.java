class Solution {
    static int ans;
    public int punishmentNumber(int n) {
        ans = 0;
        
        for(int i=1; i<n+1; i++){
            if(i == 1){
                ans++;
                continue;
            }
            
            int sq = i*i;
            if(check(sq, i)){
                ans+= sq;
            }
        }
        return ans;
    }

    private static boolean check(int sq, int num){
        if(num < 0 || sq < num){
            return false;
        }

        if(sq == num){
            return true;
        }
        return (check(sq/10, num - (sq%10)) ||
        check(sq/100, num - (sq%100)) ||
        check(sq/1000, num - (sq%1000)) );
    }

    
}