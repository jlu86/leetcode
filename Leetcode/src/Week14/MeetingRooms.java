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
    public boolean canAttendMeetings(Interval[] intervals) {
        for (int i=0; i<intervals.length; i++) {
            for (int j=i+1; j<intervals.length; j++) {
                Interval left = intervals[i];
                Interval right = intervals[j];
                if (!(right.start >= left.end || right.end <= left.start)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
