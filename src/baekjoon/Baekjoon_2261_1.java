package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_2261_1 {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Point[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new Point[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr, Comparator.comparing(point -> point.x));

        System.out.println(getMinDistance(0, n - 1));
    }

    static int getMinDistance(int start, int end) {
        if (end - start < 3) {
            int minDistance = Integer.MAX_VALUE;
            for (int i = start; i < end; i++) {
                for (int j = i + 1; j <= end; j++) {
                    minDistance = Math.min(minDistance, getDistance(arr[i], arr[j]));
                }
            }
            return minDistance;
        }

        int mid = (start + end) / 2;

        int leftMinDistance = getMinDistance(start, mid);
        int rightMinDistance = getMinDistance(mid + 1, end);
        int sideMinDistance = Math.min(leftMinDistance, rightMinDistance);

        return Math.min(sideMinDistance, getMidMinDistance(start, end, mid, sideMinDistance));
    }

    static int getMidMinDistance(int start, int end, int mid, int sideMinDistance) {
        List<Point> points = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            int xDistance = arr[i].x - arr[mid].x;

            if (Math.pow(xDistance, 2) < sideMinDistance) {
                points.add(arr[i]);
            } else if (arr[i].x > arr[mid].x) {
                break;
            }
        }

        points.sort(Comparator.comparing(point -> point.y));

        int minDistance = sideMinDistance;
        for (int i = 0; i < points.size() - 1; i++) {
            for (int j = i + 1; j < points.size(); j++) {
                int yDistance = points.get(i).y - points.get(j).y;
                if (Math.pow(yDistance, 2) < minDistance) {
                    minDistance = Math.min(minDistance, getDistance(points.get(i), points.get(j)));
                } else {
                    break;
                }
            }
        }

        return minDistance;
    }

    static int getDistance(Point p1, Point p2) {
        return (int) (Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }
}