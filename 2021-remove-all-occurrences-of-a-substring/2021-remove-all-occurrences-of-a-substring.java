class Solution {
    public String removeOccurrences(String s, String part) {
        int pos = part.length()-1;
        int n = s.length();
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for(int i=0; i<n; i++){
            stack1.push(s.charAt(i));
            while(pos >= 0 && !stack1.isEmpty() 
            && stack1.peek() == part.charAt(pos)){
                stack2.push(stack1.pop());
                pos--;
            }
            if(pos == -1){
                pos = part.length()-1;
                stack2.clear();
            }
            if(pos != -1 && !stack2.isEmpty()){
                while(!stack2.isEmpty()){
                    stack1.push(stack2.pop());
                }
                pos = part.length()-1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char i : stack1){
            sb.append(i);
        }
        return sb.toString();
    }
}