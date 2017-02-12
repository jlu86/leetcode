public class RandomizedSet {
    HashMap<Integer, Integer> valueToIndex;
    HashMap<Integer, Integer> indexToValue;
    Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        valueToIndex = new HashMap<>();
        indexToValue = new HashMap<>();
        random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        Integer index = valueToIndex.get(val);
        if (index == null) {
            int size = valueToIndex.size();
            valueToIndex.put(val, size);
            indexToValue.put(size, val);
        }
        
        return index == null;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        int size = valueToIndex.size();
        if (!valueToIndex.containsKey(val)) {
            return false;
        }
        
        Integer index = valueToIndex.get(val);
        if (index == size - 1) {
            // remove the last element directly if matched
            valueToIndex.remove(val);
            indexToValue.remove(index);
            return true;
        }
        
 
        valueToIndex.remove(val);
        
        // Swap the last element with the element to delete, then delete the last element
        Integer toSwap = indexToValue.get(size-1);
        indexToValue.put(index, toSwap);
        indexToValue.remove(size-1);
        // Update the index for the swapped element
        valueToIndex.put(toSwap, index);
            
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        // map valueToIndex is the source of truth
        int randomIndex = random.nextInt(valueToIndex.size());
        return indexToValue.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
