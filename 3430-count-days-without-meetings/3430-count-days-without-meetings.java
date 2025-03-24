class Solution {
    public int countDays(int days, int[][] meetings) {
        int ans = 0;
        int last = 0;
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        for(int[] meet : meetings){
            int start = meet[0];
            int end = meet[1];

            if(start > last + 1){
                ans += start - last - 1;
            }
            last = Math.max(last, end);
        }

        ans += days - last;
        return ans;
    }
}