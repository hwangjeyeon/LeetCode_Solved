class Solution {
    public int minimumLength(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char a : s.toCharArray()){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        
        int ans = 0;
        for(int f : map.values()){
            if(f == 0){
                continue;
            }else if(f % 2 == 0){
                ans += 2;
            }else if(f % 2 == 1){
                ans++;
            }
        } 

        return ans;
    }
}