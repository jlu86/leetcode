public class RandomizedSet {
    HashMap<Integer, Integer> valueToIndex;
    List<Integer> values;
    Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        valueToIndex = new HashMap<>();
        values = new ArrayList<>();
        random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        Integer index = valueToIndex.get(val);
        if (index == null) {
            values.add(val);
            valueToIndex.put(val, values.size() - 1);
        }
        
        return index == null;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        Integer index = valueToIndex.get(val);
        if (index != null) {
            valueToIndex.remove(val);
            values.set(index, null);
        }
        
        return index != null;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int randomIndex = random.nextInt(values.size());
        while (values.get(randomIndex) == null) {
            randomIndex = random.nextInt(values.size());
        }
        return values.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
