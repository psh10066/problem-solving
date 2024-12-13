package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_1260_2 {

    static int n;
    static int m;
    static int v;
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        input();

        visited = new boolean[n + 1];
        dfs(v);
        System.out.println();
        visited = new boolean[n + 1];
        bfs(v);
    }

    static void dfs(int i) {
        visited[i] = true;
        System.out.print(i + " ");

        graph[i].forEach(target -> {
            if (!visited[target]) {
                dfs(target);
            }
        });
    }

    static void bfs(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = true;
        System.out.print(i + " ");

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            graph[poll].forEach(target -> {
                if (!visited[target]) {
                    visited[target] = true;
                    System.out.print(target + " ");
                    queue.add(target);
                }
            });
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }
    }
}