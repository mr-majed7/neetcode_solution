//https://leetcode.com/problems/validate-binary-search-tree/submissions/1502871988/
public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode node, long left, long right) {
        if (node == null) {
            return true;
        }
        if (!(left < node.val && right > node.val)) {
            return false;
        }
        return dfs(node.left, left, node.val) && dfs(node.right, node.val, right);
    }
}
