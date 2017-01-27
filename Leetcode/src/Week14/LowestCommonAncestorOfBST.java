/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode l = p.val > q.val ? q : p;
        TreeNode g = p.val > q.val ? p : q;
        while (root != null) {
            if (root.val == l.val || root.val == g.val) {
                return root;
            }
            
            if (root.val > l.val && root.val < g.val) {
                return root;
            }
            
            if (root.val < l.val) {
                root = root.right;
            }
            
            if (root.val > g.val) {
                root = root.left;
            }
        }
        
        return root;
    }
}
