//https://leetcode.com/problems/binary-tree-right-side-view/description/
public class RightSideView {
    /**
     * Using BFS traverse the list level by level
     * From the right side only the last node of the level (going from left) will be visible
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode right = null;

            for (int i = q.size(); i > 0; i--) {
                TreeNode node = q.poll();
                if (node != null) {
                    right = node;
                    q.add(node.left);
                    q.add(node.right);
                }
            }
            if (right != null) {
                res.add(right.val);
            }
        }
        return res;
    }
}
