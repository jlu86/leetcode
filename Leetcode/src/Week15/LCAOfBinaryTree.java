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
        List<TreeNode> pathP = findPath(root, p);
        List<TreeNode> pathQ = findPath(root, q);
        
        TreeNode node = root;
        int i = pathP.size() - 1;
        int j = pathQ.size() - 1;
        while (i>=0 && j>=0 && pathP.get(i) == pathQ.get(j)) {
            node = pathP.get(i);
            i--;
            j--;
        }
        
        return node;
    }
    
    public List<TreeNode> findPath(TreeNode root, TreeNode p) {
        List<TreeNode> path = new ArrayList<>();
        if (root == null) {
            return path;
        }
        
        if (root.val == p.val) {
            path.add(root);
        } else {
            List<TreeNode> leftPath = findPath(root.left, p);
            if (!leftPath.isEmpty()) {
                leftPath.add(root);
                return leftPath;
            }
            List<TreeNode> rightPath = findPath(root.right, p);
            if (!rightPath.isEmpty()) {
                rightPath.add(root);
                return rightPath;
            }
        }
        
        return path;
    }
}
