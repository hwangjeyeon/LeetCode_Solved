class Solution {
    static int ans = 0;
    static int[] parent;
    static int[] size;
    public int countCompleteComponents(int n, int[][] edges) {
        int len = edges.length;
        ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        parent = new int[n];
        size = new int[n];
        
        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }

        for(int[] edge : edges){
            union(edge[0], edge[1]);
        }

        for(int[] edge : edges){
            int root = find(edge[0]);
            map.put(root, map.getOrDefault(root, 0) + 1);
        }
        for(int i=0; i<n; i++){
            if(find(i) == i){
                int count = size[i];
                int adj = (count * (count-1)) /2;
                if(map.getOrDefault(i, 0) == adj){
                    ans++;
                }
            }
        }
        
        return ans;
    }

    private static int find(int a){
        if(parent[a] == a){
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b){
        int x = find(a);
        int y = find(b);
        if(x == y){
            return;
        }

        if(size[x] > size[y]){
            parent[y] = x;
            size[x] += size[y];
        }else{
            parent[x] = y;
            size[y] += size[x];
        }
    }

}