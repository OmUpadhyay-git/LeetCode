
import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> a = new Stack<>();

        for (char b : s.toCharArray()) {
            if (b == '(' || b == '{' || b == '[') {
                a.push(b);
            } else {
                if (a.isEmpty()) return false;

                char c = a.pop();

                if (b == ')' && c != '(' ||
                    b == '}' && c != '{' ||
                    b == ']' && c != '[') {
                    return false;
                }
            }
        }

        return a.isEmpty();
    }
}
