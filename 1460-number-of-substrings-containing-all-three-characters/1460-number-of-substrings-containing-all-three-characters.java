class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int left = 0;
        int right = 0;
        int[] freq = new int[3];
        int ans = 0;
        while(right < n){
            char cur = s.charAt(right);
            freq[cur - 'a']++;

            while(check(freq)){
                ans += n - right;
                char lef = s.charAt(left);
                freq[lef - 'a']--;
                left++;
            }
            right++;
        }
        return ans;
    }
    private static boolean check(int[] freq){
        return freq[0] > 0 && freq[1] > 0 && freq[2] > 0;
    }
}