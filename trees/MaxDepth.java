//https://leetcode.com/problems/maximum-depth-of-binary-tree/

public class MaxDepth {
    /**
     * Using dfs search the tree and keep track of the depth at each level
     */
    public int maxDepth(TreeNode root) {
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 1));
        int res = 0;

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> curr = stack.pop();
            TreeNode node = curr.getKey();
            int depth = curr.getValue();
            if (node != null) {
                res = Math.max(res, depth);
                stack.push(new Pair<>(node.left, depth + 1));
                stack.push(new Pair<>(node.right, depth + 1));
            }
        }
        return res;
    }
}
