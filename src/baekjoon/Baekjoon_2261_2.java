package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Baekjoon_2261_2 {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Point[] arr = new Point[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr, Comparator.comparing(point -> point.x));

        int minDistance = getDistance(arr[0], arr[1]);

        TreeSet<Point> set = new TreeSet<>((p1, p2) -> {
            int yDiff = p1.y - p2.y;
            return yDiff != 0 ? yDiff : p1.x - p2.x;
        });
        set.add(arr[0]);
        set.add(arr[1]);

        int xIndex = 0;
        for (int i = 2; i < n; i++) {
            while (xIndex < i) {
                if (Math.pow(arr[i].x - arr[xIndex].x, 2) >= minDistance) {
                    set.remove(arr[xIndex]);
                    xIndex++;
                } else {
                    break;
                }
            }

            int sqrtDistance = (int) Math.ceil(Math.sqrt(minDistance));
            TreeSet<Point> iSet = (TreeSet<Point>) set.subSet(new Point(-10000, arr[i].y - sqrtDistance), new Point(10000, arr[i].y + sqrtDistance));

            for (Point point : iSet) {
                minDistance = Math.min(minDistance, getDistance(arr[i], point));
            }

            set.add(arr[i]);
        }

        System.out.println(minDistance);
    }

    static int getDistance(Point p1, Point p2) {
        return (int) (Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }
}