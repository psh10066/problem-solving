package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers_154538 {
    public class Point {
        int value;
        int count;

        public Point(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }
    public int solution(int x, int y, int n) {
        if (x == y) {
            return 0;
        }

        boolean[] visited = new boolean[y];

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, 0));

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            int value = point.value + n;
            if (value == y) {
                return point.count + 1;
            }
            if (value < y && !visited[value]) {
                visited[value] = true;
                queue.add(new Point(value, point.count + 1));
            }

            value = point.value * 2;
            if (value == y) {
                return point.count + 1;
            }
            if (value < y && !visited[value]) {
                visited[value] = true;
                queue.add(new Point(value, point.count + 1));
            }

            value = point.value * 3;
            if (value == y) {
                return point.count + 1;
            }
            if (value < y && !visited[value]) {
                visited[value] = true;
                queue.add(new Point(value, point.count + 1));
            }
        }

        return -1;
    }
}
