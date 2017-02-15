public class Solution {
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    updateAndPropagate(rooms, 1, i-1, j);
                    updateAndPropagate(rooms, 1, i+1, j);
                    updateAndPropagate(rooms, 1, i, j-1);
                    updateAndPropagate(rooms, 1, i, j+1);
                }
            }
        }
    }
    
    // Update the rooms[i][j] to min(rooms[i][j], valueToUpdate) and propagate to its neighbours
    public void updateAndPropagate(int[][] rooms, int valueToUpdate, int i, int j) {
        if (i < 0 || j < 0 || i >= rooms.length || j >= rooms[0].length) {
            // index out of bound
            return;
        }
        
        if (rooms[i][j] == -1) {
            // a wall met
            return;
        }
        
        if (rooms[i][j] <= valueToUpdate) {
            // already updated with a closer path, unnecessary to update this time
            return;
        }
        
        rooms[i][j] = valueToUpdate;
        updateAndPropagate(rooms, valueToUpdate+1, i-1, j); // up
        updateAndPropagate(rooms, valueToUpdate+1, i+1, j); // down
        updateAndPropagate(rooms, valueToUpdate+1, i, j-1); // left
        updateAndPropagate(rooms, valueToUpdate+1, i, j+1); // right
    }
}
