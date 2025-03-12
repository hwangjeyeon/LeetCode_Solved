class Solution {
    public int minimumRecolors(String blocks, int k) {
        int left = 0;
        int num = 0;
        int ans = Integer.MAX_VALUE;

        for(int right = 0; right < blocks.length(); right++){
            if(blocks.charAt(right) == 'W'){
                num++;
            }

            if(right - left + 1 == k){
                ans = Math.min(ans, num);
                if(blocks.charAt(left) == 'W'){
                    num--;
                }
                left++;
            }
        }
        return ans;
    }
}