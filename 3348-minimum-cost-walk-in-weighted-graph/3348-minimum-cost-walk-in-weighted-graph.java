class Solution {

    static int[] parent;
    static int[] depth;
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = -1;
        }
        depth = new int[n];
        int[] cost = new int[n];
        for(int i=0; i<n; i++){
            cost[i] = Integer.MAX_VALUE;
        }
        for(int[] a : edges){
            union(a[0], a[1]);
        }
        for(int[] a : edges){
            int root = find(a[0]);
            cost[root] &= a[2];
        }
        int[] ans = new int[query.length];
        for(int i=0; i<query.length; i++){
            int start = query[i][0];
            int end = query[i][1];

            if(find(start) != find(end)){
                ans[i] = -1;
            }else{
                int root = find(start);
                ans[i] = cost[root];
            }
        }
        return ans;
    }


    private static int find(int a){
        if(parent[a] == -1){
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b){
        int x = find(a);
        int y = find(b);
        if(x != y){
            parent[y] = x;
        }
    }
}