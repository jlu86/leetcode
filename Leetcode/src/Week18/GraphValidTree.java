public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n-1) {
            // a valid tree should have n-1 edges, because each node should have one
            // and only one incoming edge except the single root node.
            return false;
        }
        
        // a map to store a node and its first parent node.
        HashMap<Integer, Integer> parents = new HashMap<>();
        
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            if (!parents.containsKey(edge[1])) {
                parents.put(edge[1], edge[0]);
            } else {
                // if a node has more than one parent, it's not a tree
                return false;
            }
        }
        
        // start value of root node
        int root = -1;
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            if (!parents.containsKey(edge[0])) {
                // can't find a parent node for current node
                if (root == -1) {
                    root = edge[0];
                } else if (edge[0] == root) {
                    continue;
                } else {
                    // if more than one root is found, return false
                    return false;
                }
            }
        }
        
        return true;
    }
}
