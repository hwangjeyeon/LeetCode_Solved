class Solution {
    static boolean[] visited;
    static boolean[] cycle;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        
        visited = new boolean[n];
        cycle = new boolean[n];
        for(int i=0; i<n; i++){
            dfs(i, graph);
        }


        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(!cycle[i]){
                ans.add(i);
            }
        }
        return ans;
    }

    private static boolean dfs(int start, int[][] graph){
        if(cycle[start]){
            return true;
        }
        if(visited[start]){
            return false;
        }

        visited[start] = true;
        cycle[start] = true;
        for(int a : graph[start]){
            if(dfs(a, graph)){
                return true;
            }
        }
        cycle[start] = false;
        return false;
    }
}