package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_2146 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] nx = {0, 0, 1, -1};
        int[] ny = {1, -1, 0, 0};

        boolean[][] check = new boolean[n][n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0 || check[i][j]) continue;
                Queue<Point> queue = new LinkedList<>();
                queue.add(new Point(i, j, ++count));
                check[i][j] = true;
                while (!queue.isEmpty()) {
                    Point point = queue.poll();
                    arr[point.y][point.x] = point.num;
                    for (int k = 0; k < 4; k++) {
                        int y = point.y + ny[k];
                        int x = point.x + nx[k];
                        if (y < 0 || x < 0 || y == n || x == n) continue;
                        if (check[y][x] || arr[y][x] == 0) continue;

                        queue.add(new Point(y, x, point.num));
                        check[y][x] = true;
                    }
                }
            }
        }

        int max = 200;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) continue;
                check = new boolean[n][n];
                Queue<Point> queue = new LinkedList<>();
                queue.add(new Point(i, j, 0));
                check[i][j] = true;
                while (!queue.isEmpty()) {
                    Point point = queue.poll();
                    if (arr[point.y][point.x] > 0 && arr[point.y][point.x] != arr[i][j]) {
                        max = Math.min(max, point.num);
                        break;
                    }
                    for (int k = 0; k < 4; k++) {
                        int y = point.y + ny[k];
                        int x = point.x + nx[k];
                        if (y < 0 || x < 0 || y == n || x == n) continue;
                        if (check[y][x] || arr[y][x] == arr[i][j]) continue;

                        queue.add(new Point(y, x, point.num + 1));
                        check[y][x] = true;
                    }
                }
            }
        }

        System.out.println(max - 1);
    }

}

class Point {
    int y;
    int x;
    int num;

    public Point(int y, int x, int num) {
        this.y = y;
        this.x = x;
        this.num = num;
    }
}