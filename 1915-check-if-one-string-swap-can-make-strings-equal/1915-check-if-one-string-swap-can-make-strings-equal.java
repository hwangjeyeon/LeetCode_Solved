class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)){
            return true;
        }
        int n = s1.length();
        char[] s1Frq = new char[26];
        char[] s2Frq = new char[26];
        int diff = 0;
        for(int i=0; i<n; i++){
            char tmp1 = s1.charAt(i);
            char tmp2 = s2.charAt(i);
            if(tmp1 != tmp2){
                diff++;
                if(diff > 2){
                    return false;
                }
            }
        s1Frq[tmp1-'a']++;
        s2Frq[tmp2-'a']++;
        }
        return Arrays.equals(s1Frq, s2Frq);
    }
}