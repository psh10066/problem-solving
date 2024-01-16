package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_5014 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] check = new int[f + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        check[s] = 1;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (x == g) {
                System.out.println(check[x] - 1);
                return;
            }
            if (u > 0) {
                int up = x + u;
                if (up <= f && check[up] == 0) {
                    check[up] = check[x] + 1;
                    queue.add(up);
                }
            }

            if (d > 0) {
                int down = x - d;
                if (down > 0 && check[down] == 0) {
                    check[down] = check[x] + 1;
                    queue.add(down);
                }
            }
        }

        System.out.println("use the stairs");
    }
}