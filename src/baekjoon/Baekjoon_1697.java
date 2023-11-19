package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1697 {
    static class Point {
        int start;
        int count;

        public Point(int start, int count) {
            this.start = start;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n >= k) {
            System.out.println(n - k);
            return;
        }

        boolean[] check = new boolean[k * 2];

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(n, 0));

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            check[point.start] = true;
            if (point.start == k) {
                System.out.println(point.count);
                return;
            }

            if (point.start > 0 && !check[point.start - 1]) {
                queue.add(new Point(point.start - 1, point.count + 1));
            }
            if (point.start < k) {
                if (!check[point.start + 1]) {
                    queue.add(new Point(point.start + 1, point.count + 1));
                }
                if (!check[point.start * 2]) {
                    queue.add(new Point(point.start * 2, point.count + 1));
                }
            }
        }
    }
}