class Solution {
    public int countDays(int days, int[][] meetings) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int ans = 0; // 휴일
        int prev = days; // 이전 날짜
        int count = 0; // 현재 회의 수
        for(int[] meeting : meetings){
            prev = Math.min(prev, meeting[0]);
            map.put(meeting[0], map.getOrDefault(meeting[0], 0) + 1);
            map.put(meeting[1]+1, map.getOrDefault(meeting[1]+1, 0) - 1);
        }

        ans += (prev - 1);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int cur = entry.getKey();
            if(count == 0){
                ans += (cur - prev);
            }
            count += entry.getValue();
            prev = cur;
        }
        ans += days - prev + 1;
        
        return ans;
    }
}