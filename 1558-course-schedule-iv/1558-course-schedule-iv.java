class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge : prerequisites){
            map.computeIfAbsent(edge[0], k -> new ArrayList<>())
            .add(edge[1]);
        }

        List<Boolean> ans = new ArrayList<>();
        for(int i=0; i<queries.length; i++){
            boolean[] visited = new boolean[numCourses];
            ans.add(dfs(map, visited, queries[i][0], queries[i][1]));
        }
        return ans;
    }

    private static boolean dfs(Map<Integer, List<Integer>> map, boolean[] visited, 
    int src, int target){
        visited[src] = true;
        if(src == target){
            return true;
        }

        boolean answer = false;
        List<Integer> neighbors = map.getOrDefault(src, new ArrayList<>());
        for(int adj : neighbors){
            if(!visited[adj]){
                answer = answer || dfs(map, visited, adj, target);
            }
        }
        return answer;
    }
}