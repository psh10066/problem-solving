package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_3108 {
    static Rectangle[] rectangles;
    static boolean[] visited;

    static class Rectangle {
        int x1;
        int y1;
        int x2;
        int y2;

        public Rectangle(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        rectangles = new Rectangle[n + 1];
        rectangles[0] = new Rectangle(0, 0, 0, 0);

        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rectangles[i] = new Rectangle(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
            );
        }

        int count = -1;

        for (int i = 0; i <= n; i++) {
            if (visited[i]) continue;
            visited[i] = true;

            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);

            while (!queue.isEmpty()) {
                int before = queue.poll();

                for (int after = 1; after <= n; after++) {
                    if (before == after || visited[after] || !check(before, after)) {
                        continue;
                    }

                    visited[after] = true;
                    queue.add(after);
                }
            }

            count++;
        }

        System.out.println(count);
    }

    public static boolean check(int before, int after) {
        Rectangle b = rectangles[before];
        Rectangle a = rectangles[after];

        // b가 a를 내포하는 경우
        if (b.x1 < a.x1 && b.y1 < a.y1 && b.x2 > a.x2 && b.y2 > a.y2) {
            return false;
        }

        // a가 b를 내포하는 경우
        if (a.x1 < b.x1 && a.y1 < b.y1 && a.x2 > b.x2 && a.y2 > b.y2) {
            return false;
        }

        // 겹칠 수 없는 경우
        if (b.x1 > a.x2 || b.x2 < a.x1 || b.y1 > a.y2 || b.y2 < a.y1) {
            return false;
        }

        return true;
    }
}