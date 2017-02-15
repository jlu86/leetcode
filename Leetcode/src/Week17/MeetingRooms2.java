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
    public int minMeetingRooms(Interval[] intervals) {
        // Sort the intervals based on start time first
        for (int i = 0; i < intervals.length-1; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[j].start < intervals[i].start) {
                    Interval temp = intervals[j];
                    intervals[j] = intervals[i];
                    intervals[i] = temp;
                }
            }
        }
        
        int rooms = 0;
        for (int i = 0; i < intervals.length; i++) {
            int j = i-1;
            for (; j >= 0; j--) {
                if (intervals[j] == null) {
                    // room already reused by later meeting, continue search
                    continue;
                }
                
                if (intervals[i].start >= intervals[j].end) {
                    // no conflict, reuse the room
                    intervals[j] = null;
                    break;
                } 
            }
            
            if (j < 0) {
                // didn't find a room to reuse
                rooms++;
            }
        }
        
        return rooms;
    }
}
