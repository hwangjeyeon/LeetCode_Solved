class Solution {
    public int minOperations(int[] nums) {
        Deque<Integer> de = new ArrayDeque<>();
        int count = 0;
        for(int i=0; i<nums.length; i++){
            while(!de.isEmpty() && i > de.peekFirst() + 2){
                de.pollFirst();
            }

            if((nums[i] + de.size()) % 2 == 0){
                if(i+2 >= nums.length){
                    return -1;
                }
                count++;
                de.offerLast(i);
            }
        }
        return count;
    }
}