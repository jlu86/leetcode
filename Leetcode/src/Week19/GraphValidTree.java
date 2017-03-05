public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length == 0) {
            // Tricky input, why n=1 and edges=[] returns true, but n=2 and edges=[] returns false???
            return n == 1 ? true : false;
        }
        
        // Build a hashmap from parent to list of child nodes (undirected, so both parent and child nodes could be the key)
        HashMap<Integer, HashSet<Integer>> edgeMap = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            HashSet<Integer> edgeList = new HashSet<>();
            int parent = edges[i][0];
            int child = edges[i][1];
            // Save the mapping from a to b
            if (edgeMap.containsKey(parent)) {
                edgeList = edgeMap.get(parent);
            }
            edgeList.add(child);
            edgeMap.put(parent, edgeList);
            
            // Save the mapping from b to a
            edgeList = new HashSet<>();
            if (edgeMap.containsKey(child)) {
                edgeList = edgeMap.get(child);
            }
            edgeList.add(parent);
            edgeMap.put(child, edgeList);
        }
        
        // Create a stack to store the nodes in the current path
        Stack<Integer> stack = new Stack<>();
        // Create a hashset to record whether the node has been visited before as a child node
        HashSet<Integer> visited = new HashSet<>();
        
        int start = edges[0][0];
        stack.push(start);
        visited.add(start);
        while (!stack.empty()) {
            int parent = stack.peek();
            HashSet<Integer> children = edgeMap.get(parent);
            if (children == null || children.isEmpty()) {
                stack.pop();
            } else {
                // Get the last child node
                int child = children.iterator().next();
                if (visited.contains(child)) {
                    return false;
                }
                
                stack.push(child);
                visited.add(child);
                
                // Remove the visited node from edge map
                children.remove(child);
                edgeMap.get(child).remove(parent);
            }
        }
        
        if (visited.size() < n) {
            // There are still nodes not visited, however no connected edges can be found now, return false
            return false;
        }
        
        return true;       
    }
}
