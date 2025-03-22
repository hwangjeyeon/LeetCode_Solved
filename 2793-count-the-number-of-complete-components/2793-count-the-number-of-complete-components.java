class Solution {
    static List<Integer>[] list;
    static int ans = 0;
    static Set<Integer> visited;
    static int adj;
    static int node;
    public int countCompleteComponents(int n, int[][] edges) {
        int len = edges.length;
        list = new List[n];
        visited = new HashSet<>();
        for(int i=0; i<n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<len; i++){
            list[edges[i][0]].add(edges[i][1]);
            list[edges[i][1]].add(edges[i][0]);
        }
        ans = 0;
        for(int i=0; i<n; i++){
            if(visited.contains(i)){
                continue;
            }
            adj = 0;
            node = 0;
            dfs(i);
            if(adj == (node) * (node-1)){
                ans++;
            }
        }
        return ans;
    }
    private static void dfs(int now){
        visited.add(now);
        node++;
        adj += list[now].size();
        for(Integer edge : list[now]){
            if(!visited.contains(edge)){
                dfs(edge);
            }
           
        }
    }

}