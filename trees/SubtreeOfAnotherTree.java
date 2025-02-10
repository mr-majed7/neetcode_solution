//https://leetcode.com/problems/subtree-of-another-tree/description/
public class SubtreeOfAnotherTree {
    /**
     * For each node in the root tree check if the tree with the child nodes is same as subroot
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (sameTree(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) ||
                isSubtree(root.right, subRoot);
    }

    private boolean sameTree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 != null && node2 != null && node1.val == node2.val) {
            return sameTree(node1.left, node2.left) && sameTree(node1.right, node2.right);
        } else {
            return false;
        }
    }
}
