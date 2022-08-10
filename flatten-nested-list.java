// TC: O(n)
// SC: O(n)


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
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    ArrayList<Integer> result;
    int indx;
    public NestedIterator(List<NestedInteger> nestedList) {
        result = new ArrayList<>();
        NestedListIt(nestedList);
    }

    @Override
    public Integer next() {
        int value = result.get(indx);
        indx++;
        return value;
    }

    @Override
    public boolean hasNext() {
        return !(result.size() == indx);
    }
    
    private void NestedListIt(List<NestedInteger> nestedList) {
        for(NestedInteger num : nestedList) {
            if(num.isInteger()) {
                result.add(num.getInteger());
            } else {
                NestedListIt(num.getList());
            }
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
