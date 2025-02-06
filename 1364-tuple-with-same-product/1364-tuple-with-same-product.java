class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                map.put(nums[i]*nums[j], map.getOrDefault(nums[i]*nums[j], 0)+1);
            }
        }

        for(Integer i : map.keySet()){
            int v = map.get(i);
            int a = ((v-1) * v) /2;
            count += 8 * a;
        }

        return count;
    }
}