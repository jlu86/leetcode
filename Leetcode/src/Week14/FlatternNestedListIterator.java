/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<NestedInteger> currentList;
    int currentIdx;
    NestedIterator currentIterator;

    public NestedIterator(List<NestedInteger> nestedList) {
        currentList = nestedList;
    }

    @Override
    public Integer next() {
        if (currentIdx == currentList.size()) {
            return null;
        }
        
        NestedInteger currentElem = currentList.get(currentIdx);
        // Current element is an integer
        if (currentElem.isInteger()) {
            currentIdx++;
            return currentElem.getInteger();
        }
        
        // Current element is a list
        // Only initilize the iterator for current sub list and call its next() instead
        if (currentIterator == null) {
            currentIterator = new NestedIterator(currentElem.getList());
        }
        return currentIterator.next();
    }

    @Override
    public boolean hasNext() {
        if (currentIdx == currentList.size()) {
            return false;
        }
        
        NestedInteger currentElem = currentList.get(currentIdx);
        // Current element is an integer
        if (currentElem.isInteger()) {
            return true;
        }
        
        // Current element is a list
        // Only initilize the iterator for current sub list and call its hasNext() instead
        if (currentIterator == null) {
            currentIterator = new NestedIterator(currentElem.getList());
        }
        boolean childHasNext = currentIterator.hasNext();
        if (!childHasNext) {
            currentIdx++;
            currentIterator = null;
            return hasNext();
        }
        
        return childHasNext;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
