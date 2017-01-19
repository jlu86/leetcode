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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> stringResult = new ArrayList<>();
        if (root == null) {
            return stringResult;
        }
        
        List<List<Integer>> result = treePaths(root);
        for (int i=0; i<result.size(); i++) {
            StringBuilder builder = new StringBuilder();
            List<Integer> list = result.get(i);
            for (int j=list.size() - 1; j>=0; j--) {
                builder.append(list.get(j));
                if (j != 0) {
                    builder.append("->");
                }
            }
            stringResult.add(builder.toString());
        }
        
        return stringResult;
        
    }
    
    public List<List<Integer>> treePaths(TreeNode root) {
        if (root.left == null && root.right == null) {
            // leaf node, create a list and return
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            List<List<Integer>> result = new ArrayList<>();
            result.add(list);
            return result;
        }
        
        List<List<Integer>> result = new ArrayList<>();
        if (root.left != null) {
            List<List<Integer>> left = treePaths(root.left);
            for (int i = 0; i<left.size(); i++) {
                // Add the root node to the end of each path
                List<Integer> current = left.get(i);
                current.add(root.val);
                result.add(current);
                }
        }
        
        if (root.right != null) {
            List<List<Integer>> right = treePaths(root.right);
            for (int i = 0; i<right.size(); i++) {
                // Add the root node to the end of each path
                List<Integer> current = right.get(i);
                current.add(root.val);
                result.add(current);
                }
        }
        
        return result;
        
}
}
