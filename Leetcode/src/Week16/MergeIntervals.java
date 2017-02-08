/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        
        // Sort the list of intervals first
        Interval temp = new Interval();
        sort(intervals);
        
        // Merge the sorted list of intervals
        temp = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start <= temp.end) {
                // Merge
                temp = new Interval(temp.start, Math.max(temp.end, intervals.get(i).end));
            } else {
                // Meet the first interval that doesn't overlap
                result.add(temp);
                // Reset the temp interval
                temp = intervals.get(i);
            }
        }
        // Add the last merged or original interval
        result.add(temp);
        
        return result;
    }
    
    public void sort(List<Interval> intervals) {
         
        if (intervals == null || intervals.size() == 0) {
            return;
        }
        
        quickSort(intervals, 0, intervals.size() - 1);
    }
 
    private void quickSort(List<Interval> intervals, int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number
        Interval pivot = intervals.get(lowerIndex+(higherIndex-lowerIndex)/2);
        // Divide into two arrays
        while (i <= j) {
            while (intervals.get(i).start < pivot.start) {
                i++;
            }
            while (intervals.get(j).start > pivot.start) {
                j--;
            }
            if (i <= j) {
                exchangeIntervals(intervals, i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(intervals, lowerIndex, j);
        if (i < higherIndex)
            quickSort(intervals, i, higherIndex);
    }
 
    private void exchangeIntervals(List<Interval> intervals, int i, int j) {
        Interval temp = intervals.get(i);
        intervals.set(i, intervals.get(j));
        intervals.set(j, temp);
    }
}
