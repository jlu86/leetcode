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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
       // Create a temporary node to record the node which is the smallest one among those larger than p.
       // It should be the in-order successor of p.
       TreeNode minMax = new TreeNode(p.val - 1);
       return inorderSuccessor(root, p, minMax);
    }
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p, TreeNode minMax) {
        if (root == null) {
            return null;
        }
        
        if (p.val < root.val) {
            minMax.val = root.val;
            return inorderSuccessor(root.left, p, minMax);
        }
        
        if (p.val > root.val) {
            return inorderSuccessor(root.right, p, minMax);
        }
        
        if (p.right == null) {
            // If p has no right child and no node larger than p is found, return null.
            // Otherwise, return the smallest one which is bigger than p.
            return minMax.val > p.val ? minMax : null;
        }
        
        // If p has a right child, return the leftmost child of its right child.
        TreeNode temp = p.right;
        while (temp != null) {
            minMax = temp;
            temp = temp.left;
        }
        
        return minMax;
    }
}
