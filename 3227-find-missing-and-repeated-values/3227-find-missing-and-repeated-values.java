class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        Set<Integer> set = new HashSet<>();
        int[] ans = new int[2];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(set.contains(grid[i][j])){
                    ans[0] = grid[i][j];
                    continue;
                }
                set.add(grid[i][j]);
            }
        }
        for(int i=1; i<=grid.length*grid.length; i++){
            if(!set.contains(i)){
                ans[1] = i;
                break;
            }
        }
        return ans;
    }
}