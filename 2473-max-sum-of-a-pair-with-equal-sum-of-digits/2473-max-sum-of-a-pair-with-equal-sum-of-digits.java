class Solution {
    public int maximumSum(int[] nums) {
        int n = nums.length;
        int ans = -1;
        int[] digit = new int[82];

        for(int a : nums){
            int sum = 0;
            sum = calDigit(a);
            if(digit[sum] > 0){
                ans = Math.max(ans, digit[sum] + a);
            }
            digit[sum] = Math.max(digit[sum], a);
        }

        return ans;
    }

    private static int calDigit(int num){
        int sum = 0;
        while(num > 0){
            sum += num%10;
            num/=10;
        }
        return sum;
    }
}