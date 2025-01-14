class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] c = new int[A.length];
        int n = A.length;
        int count = 0;
        int[] arr = new int[n+1];
        for(int i=0; i<n; i++){
            if(++arr[A[i]] == 2){
                count++;
            }
            if(++arr[B[i]] == 2){
                count++;
            }
            c[i] = count;
        }
        return c;

    }
}