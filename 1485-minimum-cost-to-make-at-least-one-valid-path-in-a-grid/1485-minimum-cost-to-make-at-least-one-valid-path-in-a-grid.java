class Solution {
    
    static int[] dx = {0,1,-1,0,0};
    static int[] dy = {0,0,0,1,-1};
    static int n;
    static int m;
    static int[][] cost;
    public int minCost(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        cost = new int[n][m];
        for(int[] a : cost){
            Arrays.fill(a, Integer.MAX_VALUE);
        }
        
        bfs(0,0, grid);

        return cost[n-1][m-1];
    }

    private static void bfs(int y, int x, int[][] grid){
        Deque<int[]> q = new ArrayDeque<>();
        q.addFirst(new int[]{y,x, grid[y][x]});
        cost[y][x] = 0;
    
        while(!q.isEmpty()){
            int[] now = q.pollFirst();
            System.out.println(now[0] + " " + now[1] + " " + cost[now[0]][now[1]]);
            
            for(int i=1; i<5; i++){
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                int costs = now[2] == i ? 0 : 1;
                if(isRange(ny, nx) && cost[ny][nx] > cost[now[0]][now[1]] + costs){
                    cost[ny][nx] = cost[now[0]][now[1]] + costs; 
                    if(costs == 1){
                        q.offerLast(new int[]{ny, nx, grid[ny][nx]});
                    }else{
                        q.offerFirst(new int[]{ny, nx, grid[ny][nx]});
                    }
                    
                }
            }
        }
    }

    private static boolean isRange(int y, int x){
        return y >= 0 && y < n && x >= 0 && x < m;
    }


}