class Solution {
    public long countOfSubstrings(String word, int k) {
        long num = 0;
        int start = 0;
        int end = 0;
        HashMap<Character, Integer> vowel = new HashMap<>();
        int cons = 0;

        int[] nxt = new int[word.length()];
        int nxtCons = word.length();
        for(int i = word.length()-1; i>=0; i--){
            nxt[i] = nxtCons;
            if(!isVowel(word.charAt(i))){
                nxtCons = i;
            }
        }

        while(end < word.length()){
            char letter = word.charAt(end);

            if(isVowel(letter)){
                vowel.put(letter, vowel.getOrDefault(letter, 0) + 1);
            }else{
                cons++;
            }

            while(cons > k){
                char stl = word.charAt(start);
                if(isVowel(stl)){
                    vowel.put(stl, vowel.get(stl) - 1);
                    if(vowel.get(stl) == 0 ){
                        vowel.remove(stl);
                    }
                }else{
                    cons--;
                }
                start++;
            }
            while(start < word.length() && vowel.keySet().size() == 5 && cons == k){
                num += nxt[end] - end;
                char s = word.charAt(start);
                if(isVowel(s)){
                    vowel.put(s, vowel.get(s)-1);
                    if(vowel.get(s) == 0){
                        vowel.remove(s);
                    }
                }else{
                    cons--;
                }
                start++;
            }
            end++;
        }
        return num;
    }

    private static boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}