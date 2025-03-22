class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] list = new List[n];
        Map<List<Integer>, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            list[i] = new ArrayList<>();
            list[i].add(i);
        }

        for(int i=0; i<edges.length; i++){
            list[edges[i][0]].add(edges[i][1]);
            list[edges[i][1]].add(edges[i][0]);
        }

        for(int i=0; i<n; i++){
            List<Integer> adj = list[i];
            Collections.sort(adj);
            map.put(adj, map.getOrDefault(adj, 0) + 1);
        }
        int count = 0;
        for(Map.Entry<List<Integer>, Integer> edge : map.entrySet()){
            if(edge.getKey().size() == map.get(edge.getKey())){
                count++;
            }
        }
        return count;
    }

}