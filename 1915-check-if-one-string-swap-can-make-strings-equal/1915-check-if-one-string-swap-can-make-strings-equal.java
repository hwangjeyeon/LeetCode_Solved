class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)){
            return true;
        }else{
            int n = s1.length();
            for(int i=0; i<n; i++){
                
                for(int j=i+1; j<n; j++){
                    char[] arr = s1.toCharArray();
                    char[] arr2 = s2.toCharArray();
                    char tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    char tmp2 = arr2[i];
                    arr2[i] = arr2[j];
                    arr2[j] = tmp2;
                    String s3 = new String(arr);
                    String s4 = new String(arr2);
                    // System.out.println(s3);
                    System.out.println(s4);
                    if(s3.equals(s2)){
                        return true;
                    }
                    if(s4.equals(s1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}