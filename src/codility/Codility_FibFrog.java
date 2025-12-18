package codility;

import java.util.*;

public class Codility_FibFrog {

    public int solution(int[] A) {
        int N = A.length;

        List<Integer> fibs = getFibs(N + 1);

        boolean[] visited = new boolean[N];

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(-1, 1));

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i = 0; i < fibs.size(); i++) {
                int next = point.index + fibs.get(i);
                if (next == N) return point.count;
                if (next > N) break;

                if (A[next] == 1 && !visited[next]) {
                    visited[next] = true;
                    queue.add(new Point(next, point.count + 1));
                }
            }
        }

        return -1;
    }

    public List<Integer> getFibs(int until) {
        List<Integer> fibs = new ArrayList<>();
        fibs.add(1);
        fibs.add(2);
        while (true) {
            int size = fibs.size();
            int fibo = fibs.get(size - 1) + fibs.get(size - 2);
            if (fibo > until) break;
            fibs.add(fibo);
        }
        return fibs;
    }

    class Point {
        int index;
        int count;

        public Point(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }
}
