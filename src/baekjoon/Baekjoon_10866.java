package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baekjoon_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();

            switch (cmd) {
                case "push_front" -> deque.addFirst(Integer.parseInt(st.nextToken()));
                case "push_back" -> deque.addLast(Integer.parseInt(st.nextToken()));
                case "pop_front" -> sb.append(deque.isEmpty() ? -1 : deque.pollFirst());
                case "pop_back" -> sb.append(deque.isEmpty() ? -1 : deque.pollLast());
                case "size" -> sb.append(deque.size());
                case "empty" -> sb.append(deque.isEmpty() ? 1 : 0);
                case "front" -> sb.append(deque.isEmpty() ? -1 : deque.getFirst());
                case "back" -> sb.append(deque.isEmpty() ? -1 : deque.getLast());
            }
            if (!cmd.startsWith("push")) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}