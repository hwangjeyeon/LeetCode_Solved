class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        return check(rectangles, 0) || check(rectangles, 1);
    }

    private static boolean check(int[][] rect, int dim){
        int count = 0;

        Arrays.sort(rect, (a,b) -> Integer.compare(a[dim], b[dim]));
        int end = rect[0][dim+2];

        for(int i=1; i< rect.length; i++){
            int[] rects = rect[i];

            if(end <= rects[dim]){
                count++;
            }

            end = Math.max(end, rects[dim+2]);
        }
        return count >= 2;
    }
}