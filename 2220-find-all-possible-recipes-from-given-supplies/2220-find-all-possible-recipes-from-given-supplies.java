class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> pos = new ArrayList<>();
        Map<String, Boolean> can = new HashMap<>();
        Map<String, Integer> idx = new HashMap<>();

        for(String s : supplies){
            can.put(s, true);
        }

        for(int i=0; i< recipes.length; i++){
            idx.put(recipes[i],i);
        }

        for(String s : recipes){
            dfs(s, ingredients, new HashSet<String>(), can, idx);
            if(can.get(s)){
                pos.add(s);
            }
        }
        return pos;
    }
    private static void dfs(String recipe, List<List<String>> ingredients, Set<String> visited,
    Map<String, Boolean> can, Map<String, Integer> idx){
        if(can.containsKey(recipe) && can.get(recipe)){
            return;
        }
        if(!idx.containsKey(recipe) || visited.contains(recipe)){
            can.put(recipe, false);
            return;
        }
        visited.add(recipe);

        List<String> need = ingredients.get(idx.get(recipe));
        for(String s : need){
            dfs(s, ingredients, visited, can, idx);
            if(!can.get(s)){
                can.put(recipe, false);
                return;
            }
        }

        can.put(recipe, true);
    }
}