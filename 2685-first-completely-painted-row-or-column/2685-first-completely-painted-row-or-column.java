class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int ans = 0;
        int n = mat.length;
        int m = mat[0].length;
        Map<Integer, int[]> map = new HashMap<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map.put(mat[i][j], new int[]{i, j});
            }
        }
        int[] freqRow = new int[n];
        int[] freqCol = new int[m];
        for(int i=0; i<arr.length; i++){
            int[] pos = map.get(arr[i]);
            int numRow = ++freqRow[pos[0]];
            int numCol = ++freqCol[pos[1]];
            if(numRow == m || numCol == n){
                ans = i;
                break;
            }
        }

        return ans;
    }
}