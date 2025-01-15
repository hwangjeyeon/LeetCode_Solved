class Solution {
    public int minimizeXor(int num1, int num2) {
        int ans = num1;
        int numTwoCount = Integer.bitCount(num2);
        int ansCount = Integer.bitCount(num1);

        int pos = 0;

        while(ansCount < numTwoCount){
            if((ans & (1 << pos)) == 0){
                ans = ans | (1 << pos);
                ansCount++;
            }
            pos++;
        }

        while(ansCount > numTwoCount){
            if((ans & (1 << pos)) != 0){
                ans = ans & ~(1 << pos);
                ansCount--;
            }
            pos++;
        }

        return ans;
    }
}