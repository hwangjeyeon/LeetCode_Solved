class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<Integer>[] list = new ArrayList[n];
        for(int i=0; i<n; i++){
            list[i] = new ArrayList<>();
        }

        for(int[] a : edges){
            boolean[] visited = new boolean[n];
            if(dfs(a[0] - 1, a[1]-1, visited, list)){
                return new int[]{a[0], a[1]};
            }
            list[a[0] - 1].add(a[1]-1);
            list[a[1] - 1].add(a[0]-1);
        }
        return new int[]{};
    }
    private static boolean dfs(int src, int target, boolean[] visited, List<Integer>[] list){
        visited[src] = true;
        if(src == target){
            return true;
        }

        boolean isOk = false;
        for(int a : list[src]){
            if(!visited[a]){
                isOk = isOk || dfs(a, target, visited, list);
            }
        }
        return isOk;
    }
}