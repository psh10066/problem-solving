package codility;

import java.util.Stack;

public class Codility_Nesting {

    public int solution(String S) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            switch (S.charAt(i)) {
                case '(' -> stack.push('(');
                case ')' -> {
                    if (stack.isEmpty()) return 0;
                    stack.pop();
                }
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
