class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int[] arr = new int[colors.length + k-1];
        for(int i=0; i<colors.length; i++){
            arr[i] = colors[i];
        }
        for(int i=0; i<k-1; i++){
            arr[colors.length + i] = colors[i];
        }
        int len = arr.length;
        int ans = 0;
        int left = 0;
        int right = 1;
        while(right < len){
            if(arr[right] == arr[right-1]){
                left = right;
                right++;
                continue;
            }
            right++;
            if(right - left < k){
                continue;
            }
            ans++;
            left++;
        }
        
        return ans;
    }
}