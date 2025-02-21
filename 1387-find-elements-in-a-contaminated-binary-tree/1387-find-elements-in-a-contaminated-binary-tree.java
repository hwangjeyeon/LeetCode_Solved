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
class FindElements {

    static HashSet<Integer> set;
    public FindElements(TreeNode root) {
        set = new HashSet<>();
        dfs(root, 0);
    }
    
    public boolean find(int target) {
        if(set.contains(target)){
            return true;
        }
        return false;
    }

    private static void dfs(TreeNode root, int now){
        if(root == null){
            return;
        }
        set.add(now);
        dfs(root.left, now*2 + 1);
        dfs(root.right, now*2 + 2);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */