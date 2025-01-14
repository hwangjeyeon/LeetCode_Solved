class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] c = new int[A.length];
        for(int i=0; i<A.length; i++){
            int a = A[i];
            int b = B[i];
            int count = 0;
            for(int j=0; j<=i; j++){
                if(b == A[j]){
                    count++;
                    break;
                }
            }
            for(int j=0; j<=i; j++){
                if(a == B[j]){
                    count++;
                    break;
                }
            }
            if(a == b){
                c[i] = count/2;
            }else{
                c[i] = count;
            }
            
            if(i > 0){
                c[i] += c[i-1];
            }
        }
        return c;

    }
}