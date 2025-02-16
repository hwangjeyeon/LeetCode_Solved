class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] res = new int[n*2 - 1];
        boolean[] isNum = new boolean[n+1];
        backtracking(0, res, isNum, n);

        return res;
    }

    private static boolean backtracking(int cur, int[] res, boolean[] num, int n){
        if(cur == res.length){
            return true;
        }

        if(res[cur] != 0){
            return backtracking(cur+1, res, num, n);
        }

        for(int i=n; i>=1; i--){
            if(num[i]){
                continue;
            }
            num[i] = true;
            res[cur] = i;
            if(i == 1){
                if(backtracking(cur+1, res, num, n)){
                    return true;
                }
            }else if(cur+i < res.length && res[cur + i] == 0){
                res[cur + i] = i;
                if(backtracking(cur+1, res, num, n)){
                    return true;
                }
                res[cur+i] = 0;
            }
            res[cur] = 0;
            num[i] = false;
        }
        return false;
    }
}