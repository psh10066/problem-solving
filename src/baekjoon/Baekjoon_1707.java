package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1707 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] list = new ArrayList[v + 1];
            for (int j = 1; j <= v; j++) {
                list[j] = new ArrayList<>();
            }

            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());
                int e1 = Integer.parseInt(st.nextToken());
                int e2 = Integer.parseInt(st.nextToken());

                if (e1 != e2) {
                    list[e1].add(e2);
                    list[e2].add(e1);
                }
            }

            int[] colors = new int[v + 1];
            boolean check = true;

            loop:
            for (int j = 1; j <= v; j++) {
                Queue<Integer> queue = new LinkedList<>();
                if (colors[j] == 0) {
                    queue.add(j);
                    colors[j] = 1;

                    while (!queue.isEmpty()) {
                        int t = queue.poll();

                        for (int l = 0; l < list[t].size(); l++) {
                            int t2 = list[t].get(l);
                            if (colors[t2] == 0) {
                                queue.add(t2);
                                colors[t2] = colors[t] * -1;
                            } else if (colors[t2] == colors[t]) {
                                check = false;
                                break loop;
                            }
                        }
                    }
                }
            }
            System.out.println(check ? "YES" : "NO");
        }
    }
}