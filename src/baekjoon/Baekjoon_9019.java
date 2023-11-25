package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_9019 {
    static class Point {
        int start;
        int end;
        String command;

        public Point(int start, int end, String command) {
            this.start = start;
            this.end = end;
            this.command = command;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        Point[] arr = new Point[t];

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), "");
        }

        StringBuilder sb = new StringBuilder();

        loop:
        for (int i = 0; i < t; i++) {
            boolean[] check = new boolean[10000];
            check[arr[i].start] = true;
            Queue<Point> queue = new LinkedList<>();
            queue.add(arr[i]);

            while (!queue.isEmpty()) {
                Point point = queue.poll();
                if (point.start == point.end) {
                    sb.append(point.command).append("\n");
                    continue loop;
                }

                // D: D 는 n을 두 배로 바꾼다. 결과 값이 9999 보다 큰 경우에는 10000 으로 나눈 나머지를 취한다. 그 결과 값(2n mod 10000)을 레지스터에 저장한다.
                int d = point.start * 2 % 10000;
                if (!check[d]) {
                    check[d] = true;
                    queue.add(new Point(d, point.end, point.command + "D"));
                }

                // S: S 는 n에서 1 을 뺀 결과 n-1을 레지스터에 저장한다. n이 0 이라면 9999 가 대신 레지스터에 저장된다.
                int s = point.start != 0 ? point.start - 1 : 9999;
                if (!check[s]) {
                    check[s] = true;
                    queue.add(new Point(s, point.end, point.command + "S"));
                }

                // L: L 은 n의 각 자릿수를 왼편으로 회전시켜 그 결과를 레지스터에 저장한다. 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d2, d3, d4, d1이 된다.
                int l = point.start % 1000 * 10 + point.start / 1000;
                if (!check[l]) {
                    check[l] = true;
                    queue.add(new Point(l, point.end, point.command + "L"));
                }

                // R: R 은 n의 각 자릿수를 오른편으로 회전시켜 그 결과를 레지스터에 저장한다. 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d4, d1, d2, d3이 된다.
                int r = point.start % 10 * 1000 + point.start / 10;
                if (!check[r]) {
                    check[r] = true;
                    queue.add(new Point(r, point.end, point.command + "R"));
                }
            }
        }

        System.out.println(sb);
    }
}