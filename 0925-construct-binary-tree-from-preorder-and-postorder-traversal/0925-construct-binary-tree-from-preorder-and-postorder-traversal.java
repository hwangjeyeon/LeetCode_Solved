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

    static private int pre = 0;
    static private int post = 0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        pre = 0;
        post = 0;
        return backtracking(preorder, postorder);
    }

    private static TreeNode backtracking(int[] preorder, int[] postorder){
        TreeNode root = new TreeNode(preorder[pre++]);

        if(root.val != postorder[post]){
            root.left = backtracking(preorder, postorder);
        }

        if(root.val != postorder[post]){
            root.right = backtracking(preorder, postorder);
        }

        post++;
        return root;
    }
}