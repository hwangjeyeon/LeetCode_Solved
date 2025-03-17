class Solution {
    public boolean divideArray(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int pair = 0;
        for(Integer i : map.keySet()){
            pair += map.get(i)/2;
        }
        return (n/2) == pair;
    }
}