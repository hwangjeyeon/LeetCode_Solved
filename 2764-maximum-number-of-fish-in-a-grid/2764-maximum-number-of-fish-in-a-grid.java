class Solution {
    static int ans;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] != 0){
                    bfs(i, j, n, m, grid);
                }
            }
        }

        if(n == 1 && m == 1){
            return grid[0][0];
        }

        return ans;
    }

    private static void bfs(int y, int x, int n, int m, int[][] grid){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x});
        boolean[][] visited = new boolean[n][m];
        visited[y][x] = true;
        int count = grid[y][x];
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i=0; i<4; i++){
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(isRange(ny,nx, n, m) && !visited[ny][nx] && grid[ny][nx] != 0){
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx});
                    count += grid[ny][nx];
                }
            }
        }
        if(count == 12){
            System.out.println(y + " " + x);
        }
        ans = Math.max(ans, count);
    }
    private static boolean isRange(int y, int x, int n, int m){
        return y >=0 && y < n && x >=0 && x < m;
    }
}