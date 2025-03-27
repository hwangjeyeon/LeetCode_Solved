class Solution {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> second = new HashMap<>();
        int n = nums.size();

        for(int num : nums){
            second.put(num, second.getOrDefault(num, 0) + 1);
        }

        for(int i=0; i < n; i++){
            int num = nums.get(i);
            second.put(num, second.get(num) - 1);
            first.put(num, first.getOrDefault(num, 0) + 1);
            if(first.get(num) * 2 > i +1 && second.get(num) * 2 > n - i - 1){
                return i;
            }
        }
        return -1;
    }
}