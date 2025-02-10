//https://leetcode.com/problems/balanced-binary-tree/
public class BalancedBinaryTree {
    /**
     * Recursively using dfs for each nodes left and right subtree check the difference of depth
     */
    public boolean isBalanced(TreeNode root) {
        return dfs(root)[0] == 1;
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{1, 0};
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        boolean balanced = (left[0] == 1 && right[0] == 1) &&
                (Math.abs(left[1] - right[1]) <= 1);
        int height = 1 + Math.max(left[1], right[1]);

        return new int[]{balanced ? 1 : 0, height};

    }
}
