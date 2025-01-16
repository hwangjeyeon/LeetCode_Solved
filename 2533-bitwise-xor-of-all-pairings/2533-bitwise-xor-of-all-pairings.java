class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int xor1 = 0;
        int xor2 = 0;

        if(len2%2 != 0){
            for(int a : nums1){
                xor1 ^= a;
            }
        }

        if(len1%2 != 0){
            for(int a : nums2){
                xor2 ^= a;
            }
        }

        return xor1 ^ xor2;
    }
}