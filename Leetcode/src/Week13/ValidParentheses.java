public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            
            if (c == ')' || c == '}' || c == ']') {
                if (stack.empty()) {
                    return false;
                }
                
                char prev = stack.pop();
                if (!match(prev, c)) {
                    return false;
                }
            }
        }
        
        return stack.empty();
    }
    
    public boolean match(char left, char right) {
        return (left == '(' && right == ')')
        || (left == '{' && right == '}')
        || (left == '[' && right == ']');
    }
}
