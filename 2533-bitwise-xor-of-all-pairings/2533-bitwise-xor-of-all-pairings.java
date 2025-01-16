class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a : nums1){
            map.put(a, map.getOrDefault(a,0) + len2);
        }
        for(int a : nums2){
            map.put(a, map.getOrDefault(a,0) + len1);
        }

        int ans = 0;
        for(int a : map.keySet()){
            if(map.get(a) % 2 == 1){
                ans ^= a;
            }
        }

        return ans;
    }
}