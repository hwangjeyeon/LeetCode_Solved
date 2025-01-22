class Solution {
    static Queue<int[]> pq = new LinkedList<>();
    static int n;
    static int m;
    static int[][] arr;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public int[][] highestPeak(int[][] isWater) {
        n = isWater.length;
        m = isWater[0].length;
        arr = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = 987654321;
                if(isWater[i][j] == 1){
                    arr[i][j] = 0;
                    pq.add(new int[]{i,j,0});
                }
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        bfs();
        return arr;
    }
    private static void bfs(){
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            
            for(int i=0; i<4; i++){
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(isRange(ny,nx) && arr[ny][nx] > now[2] + 1){
                    arr[ny][nx] = now[2] + 1;
                    pq.add(new int[]{ny,nx, now[2]+1});
                }
            }
        }
    }

    private static boolean isRange(int y, int x){
        return y >=0 && y < n && x >=0 && x < m;
    }
}