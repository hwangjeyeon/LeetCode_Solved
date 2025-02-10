class Solution {
    public String clearDigits(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            if(Character.isDigit(s.charAt(i))){
                sb.deleteCharAt(sb.length()-1);
                continue;
            }
            
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
