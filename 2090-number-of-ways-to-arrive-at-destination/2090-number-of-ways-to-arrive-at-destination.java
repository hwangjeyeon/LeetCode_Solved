class Solution {
    static int MOD = 1_000_000_007;
    static List<List<int[]>> list;
    static long[] dist;
    static int[] count;
    public int countPaths(int n, int[][] roads) {
        list = new ArrayList<>();
        for(int i=0; i< n; i++){
            list.add(new ArrayList<>());
        }

        for(int[] road : roads){
            list.get(road[0]).add(new int[]{road[1], road[2]});
            list.get(road[1]).add(new int[]{road[0], road[2]});
        }
        dist = new long[n];
        count = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dijkstra();

        return count[n-1];
    }
    private static void dijkstra(){
        PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) ->{
            return Long.compare(o1[0], o2[0]);
        });
        dist[0] = 0;
        count[0] = 1;

        pq.add(new long[] {0,0});

        while(!pq.isEmpty()){
            long[] top = pq.poll();
            long curr = top[0];
            int cur = (int) top[1];

            if(curr > dist[cur]){
                continue;
            }

            for(int[] a : list.get(cur)){
                int adj = a[0];
                int time = a[1];

                if(curr + time < dist[adj]){
                    dist[adj] = curr + time;
                    count[adj] = count[cur];
                    pq.add(new long[]{dist[adj], adj});
                }else if(curr + time == dist[adj]){
                    count[adj] = (count[adj] + count[cur]) % MOD;
                }
            }

        }
 
    }

}