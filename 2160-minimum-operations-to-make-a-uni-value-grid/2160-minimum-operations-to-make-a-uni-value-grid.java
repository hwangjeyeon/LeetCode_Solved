class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> list = new ArrayList<>();
        int ans = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                list.add(grid[i][j]);
            }
        }

        Collections.sort(list);

        int len = list.size();
        int num = list.get(len / 2);

        for(int number : list){
            if(number % x != num % x){
                return -1;
            }
            ans += Math.abs(num - number) / x;
        }
        
        return ans;
    }
}