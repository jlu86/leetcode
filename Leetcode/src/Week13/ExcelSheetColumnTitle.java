public class Solution {
    public String convertToTitle(int n) {
        List<Integer> modes = new ArrayList<>();
        int div = n;
        int mode = 0;
        while (div != 0) {
            mode = div %26;
            div = div/26;
            // Add the modes in reverse order
            modes.add(mode);
        }
        
        StringBuilder result = new StringBuilder();
        for (int i=0; i<modes.size()-1; i++) {
            // replace the special 0 with 'z'
            if (modes.get(i) == 0) {
                modes.set(i, 26);
                if (i+1 < modes.size()) {
                    // it is possible to set modes[size-1] = 0, but ignore it, because it will not match to "z"
                    modes.set(i+1, modes.get(i+1) - 1);
                }
            }
        }
        
        for (int i=modes.size()-1; i>=0; i--) {
            if (modes.get(i) == 0) {
                // already replaced all 0 with 'z', so ignore the last 0
                continue;
            }
            
            char newChar = (char)('A' + modes.get(i) - 1);
            result.append(newChar);
        }
        
        return result.toString();
    }
}
