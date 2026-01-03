package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers_159993 {
    class Point {
        int y;
        int x;
        int count;
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
            this.count = 0;
        }
        public Point(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }

    char[][] road;

    public int solution(String[] maps) {
        road = new char[maps.length][maps[0].length()];

        Point S = null;
        Point E = null;
        Point L = null;

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                char c = maps[i].charAt(j);
                road[i][j] = c;

                switch (c) {
                    case 'S':
                        S = new Point(i, j);
                        break;
                    case 'E':
                        E = new Point(i, j);
                        break;
                    case 'L':
                        L = new Point(i, j);
                        break;
                }
            }
        }

        int sToL = getTime(S, L);
        if (sToL == -1) {
            return -1;
        }

        int lToE = getTime(L, E);
        if (lToE == -1) {
            return -1;
        }

        return sToL + lToE;
    }

    int[] ny = {0, 0, 1, -1};
    int[] nx = {1, -1, 0, 0};

    public int getTime(Point start, Point end) {
        boolean[][] visited = new boolean[road.length][road[0].length];

        Queue<Point> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.x == end.x && p.y == end.y) {
                return p.count;
            }

            for (int i = 0; i < 4; i++) {
                int y = p.y + ny[i];
                int x = p.x + nx[i];

                if (y >= 0 && y < road.length && x >= 0 && x < road[0].length && !visited[y][x] && road[y][x] != 'X') {
                    visited[y][x] = true;
                    queue.add(new Point(y, x, p.count + 1));
                }
            }

        }

        return -1;
    }
}
