class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[] sorted = new int[n];
        for(int i=0;i<n; i++){
            sorted[i] = nums[i];
        }
        Arrays.sort(sorted);
        int curGroup = 0;
        HashMap<Integer, Integer> numGroup = new HashMap<>();
        numGroup.put(sorted[0], curGroup);

        HashMap<Integer, LinkedList<Integer>> groupList = new HashMap<>();
        groupList.put(curGroup, new LinkedList<>(Arrays.asList(sorted[0])));

        for(int i=1; i<n; i++){
            int diff = Math.abs(sorted[i] - sorted[i-1]);
            if(diff > limit){
                curGroup++;
            }
            numGroup.put(sorted[i], curGroup);
            if(!groupList.containsKey(curGroup)){
                groupList.put(curGroup, new LinkedList<>());
            }
            groupList.get(curGroup).add(sorted[i]);
        }

        for(int i=0; i<n; i++){
            int num = nums[i];
            int group = numGroup.get(num);
            nums[i] = groupList.get(group).pop();
        }

        return nums;
    }
}