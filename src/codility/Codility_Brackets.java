package codility;

import java.util.Stack;

public class Codility_Brackets {
    public int solution(String S) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return 0;
                }
                char top = stack.pop();
                if (ch == ')' && top != '(') {
                    return 0;
                }
                if (ch == '}' && top != '{') {
                    return 0;
                }
                if (ch == ']' && top != '[') {
                    return 0;
                }
            }
        }
        if (!stack.isEmpty()) {
            return 0;
        }

        return 1;
    }
}
