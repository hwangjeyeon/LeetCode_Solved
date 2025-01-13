class Solution {
    public int minimumLength(String s) {
        int[] chars = new int[26];
        int ans = 0;
        for(char a : s.toCharArray()){
            chars[a - 'a']++;
        }

        for(int f : chars){
            if(f == 0){
                continue;
            }else if(f % 2 == 0){
                ans += 2;
            }else if(f % 2 == 1){
                ans++;
            }
        }

        return ans;
    }
}