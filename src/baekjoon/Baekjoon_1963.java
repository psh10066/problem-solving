package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1963 {
    static class Point {
        int start;
        int end;
        int count;

        public Point(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        Point[] arr = new Point[t];

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
        }

        boolean[] primeNumber = new boolean[10000];

        loop:
        for (int i = 2; i < 9998; i++) {
            for (int j = 2; j <= i / 2; j++) {
                if (primeNumber[j] && i % j == 0) continue loop;
            }
            primeNumber[i] = true;
        }

        StringBuilder sb = new StringBuilder();
        loop:
        for (int i = 0; i < t; i++) {
            boolean[] check = new boolean[10000];
            Queue<Point> queue = new LinkedList<>();
            queue.add(arr[i]);

            while (!queue.isEmpty()) {
                Point point = queue.poll();
                if (point.start == point.end) {
                    sb.append(point.count).append("\n");
                    continue loop;
                }
                check[point.start] = true;
                String startStr = String.valueOf(point.start);

                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 10; k++) {
                        StringBuilder baseStr = new StringBuilder();
                        for (int l = 0; l < 4; l++) {
                            baseStr.append(j == l ? k : startStr.charAt(l) - '0');
                        }
                        int base = Integer.parseInt(baseStr.toString());
                        if (!check[base] && base > 1000 && primeNumber[base]) {
                            queue.add(new Point(base, point.end, point.count + 1));
                        }
                    }
                }
            }

            sb.append("Impossible").append("\n");
        }

        System.out.println(sb);
    }
}