//https://leetcode.com/problems/invert-binary-tree/
public class InvertBinaryTree {
    /**
     * Iterate the tree in using DFS
     * Swap left and right node
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return root;

    }

}
