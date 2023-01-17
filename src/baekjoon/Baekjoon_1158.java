package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder("<");
        int count = 0;

        while (!queue.isEmpty()) {
            if (++count == k) {
                sb.append(queue.poll());
                if (queue.isEmpty()) break;
                count = 0;
                sb.append(", ");
            } else {
                queue.add(queue.poll());
            }
        }

        System.out.println(sb.append(">"));
    }
}