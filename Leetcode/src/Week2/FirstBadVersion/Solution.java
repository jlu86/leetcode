package Week2.FirstBadVersion;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * @author jielu
 *
 */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int curFirst = Integer.MAX_VALUE;
        
        // v1 error: end condition is not correct (end != start), so infinite loop
        while (start > 0 && end <= n && end > start) {
        	// v2 error: mid = (1 + n) / 2
        	// v3 error: (start + end) > Integer.MAX_VALUE
            int mid = start / 2 + end / 2;
            if (isBadVersion(mid)) {
            	// first bad version should be <= mid
            	curFirst = Math.min(curFirst, mid);
            	end = mid - 1;
            	if (end <= n && !isBadVersion(end)) {
            		return curFirst;
            	}
            } else {
            	// first bad version should be > mid
            	start = mid + 1;
            	if (start >0 && isBadVersion(start)) {
            		return start;
            	}
            }
        }
        
        if (start == end && isBadVersion(start)) {
        	curFirst = Math.min(curFirst, start);
        }
        
        return curFirst;
    }
    
    @Test
    public void test() {
    	Solution solution = new Solution();
    	assertEquals(1702766719, solution.firstBadVersion(2126753390));
    }
}