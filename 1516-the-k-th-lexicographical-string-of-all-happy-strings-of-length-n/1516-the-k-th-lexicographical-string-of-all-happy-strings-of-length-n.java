class Solution {
    static String[] word = {"a", "b","c"};
    static List<String> ans;
    public String getHappyString(int n, int k) {
        ans = new ArrayList<>();
        backtracking(n,k, 0, "");
        Collections.sort(ans);
        for(int i=0; i<ans.size(); i++){
            System.out.println(ans.get(i));
        }

        return ans.size() < k ? "" : ans.get(k-1);
    }
    private static void backtracking(int n, int k, int depth, String s){
        if(depth == n){
            if(happy(s)){
                ans.add(s);
            }
            return;
        }

        for(int i=0; i<3; i++){
            backtracking(n,k,depth+1, s + word[i]);
        }

    }

    private static boolean happy(String a){
        for(int i=1; i<a.length(); i++){
            if(a.charAt(i) == a.charAt(i-1)){
                return false;
            }
        }
        return true;
    }

}