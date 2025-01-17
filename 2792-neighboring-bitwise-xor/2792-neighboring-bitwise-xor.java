class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int[] first = new int[n+1];
        int[] second = new int[n+1];
        first[0] = 0;
        second[0] = 1;
        for(int i=0; i<n; i++){
            first[i+1] = derived[i] ^ first[i];
            second[i+1] =  derived[i] ^ second[i];
        }

        return (first[0] == first[n]) || (second[0] == second[n]);
    }
}