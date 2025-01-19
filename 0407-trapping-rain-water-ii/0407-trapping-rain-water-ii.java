class Solution {
    static int[] dy = {0,0,-1,1};
    static int[] dx = {-1,1,0,0};
    static boolean[][] visited;
    static int n;
    static int m;
    static int ans;
    public int trapRainWater(int[][] heightMap) {
        n = heightMap.length;
        m = heightMap[0].length;
        visited = new boolean[n][m];
        ans = 0;
        bfs(heightMap);

        return ans;
    }

    private static void bfs(int[][] heightMap){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[0] - o2[0];
        });
        

        for(int i=0; i<n; i++){
            pq.add(new int[]{heightMap[i][0], i, 0});
            pq.add(new int[]{heightMap[i][m-1], i, m-1});
            visited[i][0] = true;
            visited[i][m-1] = true;
        }

        for(int i=0; i<m; i++){
            pq.add(new int[]{heightMap[0][i], 0, i});
            pq.add(new int[]{heightMap[n-1][i], n-1, i});
            visited[0][i] = true;
            visited[n-1][i] = true;
        }

        while(!pq.isEmpty()){
            int[] now = pq.poll();

            for(int i=0; i<4; i++){
                int ny = now[1] + dy[i];
                int nx = now[2] + dx[i];
                if(isRange(ny, nx) && !visited[ny][nx]){
                    int nh = heightMap[ny][nx];
                    if(nh < now[0]){
                        ans += now[0] - nh;
                    }
                    visited[ny][nx] = true;
                    pq.add(new int[]{Math.max(nh, now[0]), ny, nx});
                }
            }
        }
    }

    private static boolean isRange(int ny, int nx){
        return ny >=0 && ny < n && nx >=0 && nx < m;
    }
}