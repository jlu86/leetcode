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
        // The last node removed from the stack
        TreeNode pop = new TreeNode(-1);
        // The parent node of the last node removed from the stack, i.e. the diverge node
        TreeNode parent = null;
        TreeNode peek = null;
        // How many nodes are met
        int met = 0;
        TreeNode firstMet = null;
        
        Stack<TreeNode> stack = new Stack<>();
        
        // Traverse the binary tree until both p and q are met
        met = pushAndUpdate(stack, root, p, q, met);
        while (!stack.empty()) {
            peek = stack.peek();
            if ((peek == p || peek == q) && firstMet == null) {
            	firstMet = peek;
            }
            
            if (pop != peek.left && pop != peek.right) {
                // The left path has not been visited yet
                if (peek.left != null) {
                    met = pushAndUpdate(stack, peek.left, p, q, met);
                } else if (peek.right != null) {
                    met = pushAndUpdate(stack, peek.right, p, q, met);
                } else {
                    // The peek node is a left node, pop from the stack
                    parent = popAndUpdate(stack, p, q, pop, parent);
                }
            } else if (pop == peek.left) {
                // The left path has already been visited, try the right path
                if (peek.right != null) {
                    met = pushAndUpdate(stack, peek.right, p, q, met);
                } else {
                  parent = popAndUpdate(stack, p, q, pop, parent);
                }
            } else {
                // Both left and right paths have been visited, pop the peek from the stack
                parent = popAndUpdate(stack, p, q, pop, parent);
            }
            
            if (met == 2) {
                // Already found the two nodes, just pop all the elements from the stack to find LCA
                break;
            }
        }
        
        if (parent != null) {
            // p and q are not in the same path, so return the diverge node of p and q
            return parent;
        }
        
        // p and q are in the same path, return the node firstly met in the path
        return firstMet;
    }
    
    // Push the given node to the stack and also update how many node of p and q are already met
    public int pushAndUpdate(Stack<TreeNode> stack, TreeNode node, TreeNode p, TreeNode q, int met) {
        stack.push(node);
        if (node == p || node == q) {
            met++;
        }
        
        return met;
    }
    
    // ????? why parent node can't be updated in the method
    public TreeNode popAndUpdate(Stack<TreeNode> stack, TreeNode p, TreeNode q, TreeNode pop, TreeNode parent) {
        pop = stack.pop();
        if (pop == p || pop == q || pop == parent) {
            // Backtrack the furthest node in the path of first matched node
            return stack.peek();
        }
        
        return parent;
    }
}
