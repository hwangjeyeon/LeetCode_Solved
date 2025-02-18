class Solution {
    public String smallestNumber(String pattern) {
        return String.valueOf(backtracking(pattern, 0,0,0));
    }

    private static int backtracking(String pattern, int depth, int mask, int cur){
        if(depth > pattern.length()){
            return cur;
        }

        int ans = Integer.MAX_VALUE;
        int last = cur % 10;
        boolean inc = depth == 0 || pattern.charAt(depth - 1) == 'I';

        for(int i = 1; i < 10; i++){
            if((mask & (1 << i)) == 0 && i > last == inc){
                ans = Math.min(ans, backtracking(pattern, depth+1, mask | (1 << i), cur * 10 + i));
            }
        }
        return ans;
    }

}