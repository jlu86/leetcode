/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        if (n == 0) {
            return 0;
        }
        
        char[] read4Buf = new char[4];
        int read4Current = 0;
        int current = 0;
        while ((read4Current = read4(read4Buf)) == 4) {
                // Append the read buf to the output buffer
                for (int i=0; i<4; i++) {
                    if (current >= n) {
                        break;
                    }
                    
                    buf[current] = read4Buf[i];
                    current++;
                }
            }
            
            for (int i=0; i<read4Current && current < n; i++) {
                buf[current] = read4Buf[i];
                current++;
            }
        
        return current;
    }
}
