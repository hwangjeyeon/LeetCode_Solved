class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> ball = new HashMap<>();
        int[] ans = new int[n];
        
        for(int i=0; i<n; i++){
            int b = queries[i][0];
            int c = queries[i][1];

            if(ball.containsKey(b)){
                int pre = ball.get(b);
                map.put(pre, map.get(pre)-1);
                if(map.get(pre) == 0){
                    map.remove(pre);
                }
            }
            ball.put(b, c);
            map.put(c, map.getOrDefault(c, 0) + 1);

            ans[i] = map.size();
        }
        return ans;
    }
}