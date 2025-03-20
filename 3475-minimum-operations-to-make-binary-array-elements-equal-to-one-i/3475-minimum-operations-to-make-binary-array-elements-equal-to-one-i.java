class Solution {
    public int minOperations(int[] nums) {
        Deque<Integer> de = new ArrayDeque<>();
        int count = 0;
        for(int i=0; i<nums.length; i++){
            while(!de.isEmpty() && de.peek() + 2 < i){
                de.pollFirst();
            }

            if((nums[i] + de.size()) % 2 == 0){
                if(i + 2 >= nums.length){
                    return -1;
                }
                de.addLast(i);
                count++;
            }
        }

        return count;
    }
}