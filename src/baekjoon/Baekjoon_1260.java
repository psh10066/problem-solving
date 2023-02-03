package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1260 {
    static boolean[][] isNode;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        isNode = new boolean[n + 1][n + 1];
        check = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int e1 = Integer.parseInt(st.nextToken());
            int e2 = Integer.parseInt(st.nextToken());
            isNode[e1][e2] = isNode[e2][e1] = true;
        }

        dfs(v);
        System.out.println();

        check = new boolean[n + 1];

        bfs(v);
        System.out.println();
    }

    static void dfs(int v) {
        System.out.print(v + " ");
        check[v] = true;

        for (int i = 1; i < isNode.length; i++) {
            if (isNode[v][i] && !check[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        check[v] = true;

        while (!queue.isEmpty()) {
            v = queue.poll();
            System.out.print(v + " ");

            for (int i = 1; i < isNode.length; i++) {
                if (isNode[v][i] && !check[i]) {
                    queue.add(i);
                    check[i] = true;
                }
            }
        }
    }
}