//https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
public class KthSmallest {
    /**
     * Using dfs perform inorder traversla
     */

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<>();
        dfs(root, arr);
        return arr.get(k - 1);
    }

    private void dfs(TreeNode node, List<Integer> arr) {
        if (node == null) {
            return;
        }

        dfs(node.left, arr);
        arr.add(node.val);
        dfs(node.right, arr);
    }
}
