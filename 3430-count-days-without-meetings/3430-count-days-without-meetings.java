class Solution {
    public int countDays(int days, int[][] meetings) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int pre = 0;
        int free = 0;
        int prev = days;
        for(int[] meeting : meetings){
            prev = Math.min(prev, meeting[0]);
            map.put(meeting[0], map.getOrDefault(meeting[0], 0) + 1);
            map.put(meeting[1] + 1, map.getOrDefault(meeting[1] + 1, 0) - 1);
        }

        free += (prev - 1);
        for(Map.Entry<Integer, Integer> now : map.entrySet()){
            int cur = now.getKey();
            if(pre == 0){
                free += (cur - prev);
            }
            pre += now.getValue();
            prev = cur;
        }
        free += days - prev + 1;
        
        return free;
    }
}