// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
public class LCA {
    /**
     * We can find LCA by checking at which point two nodes goes to separate tree
     * Because of the characteristics of BST this can be done simply.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;

        while (curr!=null){
            if (p.val>curr.val && q.val > curr.val){
                curr = curr.right;
            }else if (p.val < curr.val && q.val < curr.val){
                curr = curr.left;
            }else{
                return curr
            }
        }
        return null;

    }
}
