package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[n + 1];
        List<Integer>[] list = new LinkedList[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new LinkedList<>();
        }
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            Queue<Integer> queue = new LinkedList<>();
            if (!check[i]) {
                count++;
                queue.add(i);
                check[i] = true;
                while (!queue.isEmpty()) {
                    int t = queue.poll();

                    for (int j = 0; j < list[t].size(); j++) {
                        int r = list[t].get(j);
                        if (!check[r]) {
                            queue.add(list[t].get(j));
                            check[r] = true;
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}