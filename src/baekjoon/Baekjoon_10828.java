package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();

            switch (cmd) {
                case "push" -> stack.push(Integer.parseInt(st.nextToken()));
                case "pop" -> sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
                case "size" -> sb.append(stack.size()).append("\n");
                case "empty" -> sb.append(stack.isEmpty() ? 1 : 0).append("\n");
                case "top" -> sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
            }
        }
        System.out.println(sb);
    }
}