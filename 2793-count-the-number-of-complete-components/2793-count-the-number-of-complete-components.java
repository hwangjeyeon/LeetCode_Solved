class Solution {
    static List<Integer>[] lists;
    static int ans;
    static Set<Integer> visited;
    public int countCompleteComponents(int n, int[][] edges) {
        lists = new List[n];
        for(int i=0; i<n; i++){
            lists[i] = new ArrayList<>();
        }

        for(int i=0; i<edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            lists[a].add(b);
            lists[b].add(a);
        }
        ans = 0;
        visited = new HashSet<>();
        for(int i=0; i<n; i++){
            if(visited.contains(i)){
                continue;
            }
            int[] info = new int[2];
            dfs(n, i, info);
            if(info[0] * (info[0] - 1) == info[1]){
                ans++;
            }
        }
        return ans;
    }

    private static void dfs(int n, int now, int[] info){
        visited.add(now);
        info[0]++;
        info[1] += lists[now].size();

        for(Integer i : lists[now]){
            if(!visited.contains(i)){
                dfs(n, i, info);
            }
        }

    }
}