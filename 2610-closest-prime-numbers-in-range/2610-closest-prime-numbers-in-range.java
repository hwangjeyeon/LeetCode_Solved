class Solution {
    public int[] closestPrimes(int left, int right) {
        int[] arr = find(right);

        List<Integer> primes = new ArrayList<>();
        for(int i=left; i<=right; i++){
            if(arr[i] == 1){
                primes.add(i);
            }
        }

        if(primes.size() < 2){
            return new int[]{-1,-1};
        }
        int min = Integer.MAX_VALUE;
        int[] close = new int[2];
        Arrays.fill(close, -1);

        for(int i=1; i<primes.size(); i++){
            int diff = primes.get(i) - primes.get(i-1);
            if(diff < min){
                min = diff;
                close[0] = primes.get(i-1);
                close[1] = primes.get(i);
            }
        }
        return close;
    }

    private static int[] find(int upper){
        int[] tmp = new int[upper+1];
        Arrays.fill(tmp, 1);

        tmp[0] = 0;
        tmp[1] = 0;

        for(int i=2; i*i<=upper; i++){
            if(tmp[i] == 1){
                for(int j=i*i; j<=upper; j+=i){
                    tmp[j] = 0;
                }
            }
        }
        return tmp;
    }
}