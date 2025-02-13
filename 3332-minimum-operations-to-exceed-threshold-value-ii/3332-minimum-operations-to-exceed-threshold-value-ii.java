class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            pq.add((long)nums[i]);
        }
        int ans = 0;
        while(pq.size() >= 2 && pq.peek() < k){
            long a = pq.poll();
            long b = pq.poll();
            pq.add(Math.min(a,b)*2 + Math.max(a,b));
            ans++;
            System.out.println(a + " " + b);
        }

        return ans;
    }
}