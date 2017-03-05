public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n <= 1) {
            return true;
        }
        
        // Build a hashmap from parent to list of child nodes
        HashMap<Integer, List<Integer>> edgeMap = new HashMap<>();
        // Use a hashset to note whether there are parent nodes for current nodes
        HashSet<Integer> nonRootSet = new HashSet<>();
        for (int i = 0; i < edges.length; i++) {
            List<Integer> edgeList = new ArrayList<>();
            int parent = edges[i][0];
            int child = edges[i][1];
            if (edgeMap.containsKey(parent)) {
                edgeList = edgeMap.get(parent);
            }
            edgeList.add(child);
            edgeMap.put(parent, edgeList);
            // Update non-root set
            nonRootSet.add(child);
        }
       
       // Find root node 
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (!nonRootSet.contains(i)) {
                root = i;
            }
        }
        
        if (root == -1) {
            return false;
        }
        
        // Create a stack to store the nodes in the current path
        Stack<Integer> stack = new Stack<>();
        // Create a hashset to record whether the node has been visited before as a child node
        HashSet<Integer> visited = new HashSet<>();
        stack.push(0);
        visited.add(0);
        while (!stack.empty()) {
            int parent = stack.peek();
            List<Integer> children = edgeMap.get(parent);
            if (children == null || children.isEmpty()) {
                stack.pop();
            } else {
                // Get the last child node
                int child = children.get(children.size() - 1);
                children.remove(children.size() - 1);
                if (visited.contains(child)) {
                    return false;
                }
                
                stack.push(child);
                visited.add(child);
            }
        }
        
        if (visited.size() < n) {
            // There are still nodes not visited, however no connected edges can be found now, return false
            return false;
        }
        
        return true;       
    }
}
