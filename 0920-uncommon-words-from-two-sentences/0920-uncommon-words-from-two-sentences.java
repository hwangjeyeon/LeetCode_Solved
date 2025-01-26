class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] a1 = s1.split(" ");
        String[] a2 = s2.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for(String s: a1){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for(String s: a2){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        List<String> ans = new ArrayList<>();
        for(String s : map.keySet()){
            if(map.get(s) == 1){
                ans.add(s);
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}