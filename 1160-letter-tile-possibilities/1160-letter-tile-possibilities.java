class Solution {
    static int ans;
    static Set<String> set;
    static char[] alpha;
    public int numTilePossibilities(String tiles) {
        ans = 0;
        set = new HashSet<>();
        alpha = new char[26];
        for(int i=0; i<tiles.length(); i++){
            alpha[tiles.charAt(i) - 'A']++;
        }
        backtracking(tiles, "", 0, tiles.length());
        
        return ans;
    }

    private static void backtracking(String tiles, String s, int depth, int n){
        if(depth == n){
            if(!s.isEmpty() && !set.contains(s)){
                set.add(s);
                System.out.println(s);
                ans++;
            }
            return;
        }
        backtracking(tiles, s, depth+1, n);
        for(int i=0; i<n; i++){
            if(alpha[tiles.charAt(i) - 'A'] >= 1){
                alpha[tiles.charAt(i) - 'A']--;
                backtracking(tiles, s + tiles.charAt(i), depth+1, n);
                alpha[tiles.charAt(i) - 'A']++;
            }
        }
        
    }
}