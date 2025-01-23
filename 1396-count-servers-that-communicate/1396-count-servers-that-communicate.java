class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    boolean isOk = false;
                    for(int k=0; k<m; k++){
                        if(k != j && grid[i][k] == 1){
                            isOk = true;
                            break;
                        }
                    }
                    if(isOk){
                        ans++;
                    }else{
                        for(int k = 0; k<n; k++){
                            if(k!=i && grid[k][j] == 1){
                                isOk = true;
                                break;
                            }
                        }
                        if(isOk){
                            ans++;
                            break;
                        }
                    }
                }
            }
        }

        

        return ans;
    }
}