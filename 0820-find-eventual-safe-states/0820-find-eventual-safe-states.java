class Solution {
    static boolean[] visited;
    static boolean[] check;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        
        visited = new boolean[n];
        check = new boolean[n];
        for(int i=0; i<n; i++){
            dfs(i, graph);
        }


        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(!check[i]){
                ans.add(i);
            }
        }
        return ans;
    }

    private static boolean dfs(int start, int[][] graph){
        if(check[start]){
            return true;
        }
        if(visited[start]){
            return false;
        }

        visited[start] = true;
        check[start] = true;
        for(int a : graph[start]){
            if(dfs(a, graph)){
                return true;
            }
        }
        check[start] = false;
        return false;
    }
}