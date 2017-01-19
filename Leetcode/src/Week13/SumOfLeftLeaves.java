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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int sum = 0;
        // Check whether root has left leaf
        TreeNode left = root.left;
        if (left != null && left.left == null && left.right == null) {
            sum += left.val;
        } else {
            sum += sumOfLeftLeaves(root.left);
        }
        
        // Also add the sum of left leaves of right child
        sum += sumOfLeftLeaves(root.right);
        
        return sum;
    }
}
