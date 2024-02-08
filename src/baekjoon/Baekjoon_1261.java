package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1261 {
    static class Point implements Comparable<Point> {
        int y;
        int x;
        int count;

        public Point(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }

        @Override
        public int compareTo(Point o) {
            return this.count - o.count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] arr = new char[m][n];
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int[] ny = {1, -1, 0, 0};
        int[] nx = {0, 0, 1, -1};

        Queue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(0, 0, 0));

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            if (point.y == m - 1 && point.x == n - 1) {
                System.out.println(point.count);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int yy = point.y + ny[i];
                int xx = point.x + nx[i];

                if (yy < 0 || xx < 0 || yy == m || xx == n || visited[yy][xx]) {
                    continue;
                }
                visited[yy][xx] = true;
                queue.add(new Point(yy, xx, arr[yy][xx] == '1' ? point.count + 1 : point.count));
            }
        }
    }
}