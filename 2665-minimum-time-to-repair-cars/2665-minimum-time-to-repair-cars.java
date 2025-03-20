class Solution {
    public long repairCars(int[] ranks, int cars) {
        int min = ranks[0];
        int max = ranks[0];
        for(int rank : ranks){
            min = Math.min(min, rank);
            max = Math.max(max, rank);
        }
        int[] freq = new int[max + 1];
        for(int rank : ranks){
            min = Math.min(min, rank);
            freq[rank]++;
        }

        long left = 1;
        long right = 1L * min * cars * cars;

        while(left < right){
            long mid = (left + right) / 2;
            long count = 0;
            for(int i=1; i<max + 1; i++){
                count += freq[i] * (long) Math.sqrt(mid / (long) i);
            }

            if(count >= cars){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}