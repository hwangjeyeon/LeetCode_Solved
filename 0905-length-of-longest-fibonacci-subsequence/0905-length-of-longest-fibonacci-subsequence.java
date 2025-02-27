class Solution {
    static int ans = 0;
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        ans = 0;
        Set<Integer> set = new HashSet<>();
        for(int i : arr){
            set.add(i);
        }
        for(int i=0; i< n; i++){
            for(int j=i+1; j<n; j++){
                int pre = arr[j];
                int curr = arr[i] + arr[j];
                int len = 2;

                while(set.contains(curr)){
                    int tmp = curr;
                    curr += pre;
                    pre = tmp;
                    len++;
                    ans = Math.max(ans, len);
                }
            }
        }

        return ans;
    }
}
