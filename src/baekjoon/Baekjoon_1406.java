package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            leftStack.push(s.charAt(i));
        }

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "L" -> {
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                }
                case "D" -> {
                    if (!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                }
                case "B" -> {
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                }
                case "P" -> {
                    leftStack.push(st.nextToken().charAt(0));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < leftStack.size(); i++) {
            sb.append(leftStack.get(i));
        }
        for (int i = rightStack.size() - 1; i >= 0; i--) {
            sb.append(rightStack.get(i));
        }
        System.out.println(sb);
    }
}