class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] c = new int[A.length];
        Set<Integer> set = new HashSet<>();
        int n = A.length;
        int count = 0;
        for(int i=0; i<n; i++){
            
            if(!set.contains(A[i])){
                set.add(A[i]);
            }else{
                count++;
            }

            if(!set.contains(B[i])){
                set.add(B[i]);
            }else{
                count++;
            }

            c[i] = count;
        }
        return c;

    }
}