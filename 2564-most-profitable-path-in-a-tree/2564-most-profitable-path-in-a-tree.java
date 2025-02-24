class Solution {
    static List<List<Integer>> tree;
    static int[] dis;
    static int max;
    static Map<Integer, Integer> bobPath;
    static boolean[] visited;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        tree = new ArrayList<>();
        for(int i=0; i<n; i++){
            tree.add(new ArrayList<>());
        }
        dis = new int[n];
        for(int[] ed : edges){
            tree.get(ed[0]).add(ed[1]);
            tree.get(ed[1]).add(ed[0]);
        }
        visited = new boolean[n];
        bobPath = new HashMap<>();
        max = Integer.MIN_VALUE;
        findB(bob, 0);
        visited = new boolean[n];
        findA(0,0,0,amount);
        
        return max;
    }
    
    private static boolean findB(int s, int time){
        bobPath.put(s, time);
        visited[s] = true;
        if(s == 0){
            return true;
        }

        for(int adj : tree.get(s)){
            if(!visited[adj] && findB(adj, time+1)){
                return true;
            }
        }
        bobPath.remove(s);
        return false;
    }

    private static void findA(int s, int time, int m, int[] amount){
        visited[s] = true;
        if(!bobPath.containsKey(s) || time < bobPath.get(s)){
            m += amount[s];
        }else if(time == bobPath.get(s)){
            m += amount[s] / 2;
        }

        if(tree.get(s).size() == 1 && s != 0){
            max = Math.max(max, m);
        }

        for(int adj: tree.get(s)){
            if(!visited[adj]){
                findA(adj, time+1, m, amount);
            }
        }
    }

}