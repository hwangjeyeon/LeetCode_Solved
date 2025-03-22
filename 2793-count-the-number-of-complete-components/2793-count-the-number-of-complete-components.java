class Solution {
    static List<Integer>[] list;
    static int ans = 0;
    static boolean[] visited;
    static int adj;
    static int node;
    static List<Integer> nodes;
    public int countCompleteComponents(int n, int[][] edges) {
        int len = edges.length;
        list = new List[n];
        visited = new boolean[n];
        for(int i=0; i<n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<len; i++){
            list[edges[i][0]].add(edges[i][1]);
            list[edges[i][1]].add(edges[i][0]);
        }
        ans = 0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                nodes = new ArrayList<>();
                bfs(i);
                boolean isOk = true;
                for(int a : nodes){
                    if(list[a].size() != nodes.size() - 1){
                        isOk = false;
                        break;
                    }
                }
                if(isOk){
                    ans++;
                }
            }
        }
        return ans;
    }

    private static void bfs(int now){
        Queue<Integer> q = new LinkedList<>();
        q.add(now);
        visited[now] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            nodes.add(cur);
            for(int adj : list[cur]){
                if(!visited[adj]){
                    q.add(adj);
                    visited[adj] = true;
                }
            }
        }
    }

}