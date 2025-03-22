class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] list = new List[n];
        Map<List<Integer>, Integer> freq = new HashMap<>();

        for(int i=0; i<n; i++){
            list[i] = new ArrayList<>();
            list[i].add(i);
        }
        for(int[] edge : edges){
            list[edge[0]].add(edge[1]);
            list[edge[1]].add(edge[0]);
        }

        for(int i=0; i< n; i++){
            List<Integer> adj = list[i];
            Collections.sort(adj);
            freq.put(adj, freq.getOrDefault(adj, 0) + 1);
        }

        int count = 0;
        for(Map.Entry<List<Integer>, Integer> entry : freq.entrySet()){
            if(entry.getKey().size() == entry.getValue()){
                count++;
            }
        }
        return count;
    }

}