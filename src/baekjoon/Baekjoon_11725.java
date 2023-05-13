package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Integer[] parent = new Integer[n + 1];
        parent[1] = 0;

        List<Integer>[] connect = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            connect[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            connect[x].add(y);
            connect[y].add(x);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            connect[index].forEach(value -> {
                if (parent[value] == null) {
                    parent[value] = index;
                    queue.add(value);
                }
            });
        }

        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }
}