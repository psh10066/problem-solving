package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int last = -1;

        Queue<Integer> queue = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();

            switch (cmd) {
                case "push" -> {
                    last = Integer.parseInt(st.nextToken());
                    queue.add(last);
                }
                case "pop" -> sb.append(queue.isEmpty() ? -1 : queue.poll());
                case "size" -> sb.append(queue.size());
                case "empty" -> sb.append(queue.isEmpty() ? 1 : 0);
                case "front" -> sb.append(queue.isEmpty() ? -1 : queue.peek());
                case "back" -> sb.append(queue.isEmpty() ? -1 : last);
            }
            if (!cmd.equals("push")) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}