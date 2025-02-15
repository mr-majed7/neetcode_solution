//https://leetcode.com/problems/count-good-nodes-in-binary-tree/
public class GoodNodes {
    /**
     * Run dfs
     * For each side check if it is the maximum value at that point
     */
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode root, int maxVal) {
        if (root == null) {
            return 0;
        }

        int res = (root.val >= maxVal) ? 1 : 0;
        maxVal = Math.max(maxVal, root.val);
        res += dfs(root.left, maxVal);
        res += dfs(root.right, maxVal);
        return res;
    }
}
