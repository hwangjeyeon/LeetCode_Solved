/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static int idx = 0;
    public TreeNode recoverFromPreorder(String traversal) {
        idx = 0;
        return backtracking(traversal, 0);
    }
    
    private static TreeNode backtracking(String traversal, int depth){
        if(idx >= traversal.length()){
            return null;
        }
        int count = 0;
        while((idx + count) < traversal.length() && traversal.charAt(idx + count) == '-'){
            count++;
        }

        if(count != depth){
            return null;
        }
        idx += count;
        int a = 0;
        while(idx < traversal.length() && Character.isDigit(traversal.charAt(idx))){
            a = a * 10 + (traversal.charAt(idx++) - '0');
        }
        TreeNode node = new TreeNode(a);

        node.left = backtracking(traversal, depth+1);
        node.right = backtracking(traversal, depth+1);
        return node;
    }
}