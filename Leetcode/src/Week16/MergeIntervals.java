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
        
        for (int i = 0; i < intervals.size()-1; i++) {
            for (int j = i+1; j < intervals.size(); j++) {
                Interval left = intervals.get(i);
                Interval right = intervals.get(j);
                if (right.start < left.start) {
                    intervals.set(i, right);
                    intervals.set(j, left);
                }
            }
        }
        
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
}
