package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_11662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int Ax = Integer.parseInt(st.nextToken());
        int Ay = Integer.parseInt(st.nextToken());
        int Bx = Integer.parseInt(st.nextToken());
        int By = Integer.parseInt(st.nextToken());
        int Cx = Integer.parseInt(st.nextToken());
        int Cy = Integer.parseInt(st.nextToken());
        int Dx = Integer.parseInt(st.nextToken());
        int Dy = Integer.parseInt(st.nextToken());

        double epsilon = 1e-6;

        double min = 0;
        double max = 1;

        while (max - min > epsilon) {
            double div = (max - min) / 3;
            double lo = min + div;
            double hi = max - div;

            double loD = getDistance(Ax + (Bx - Ax) * lo, Cx + (Dx - Cx) * lo, Ay + (By - Ay) * lo, Cy + (Dy - Cy) * lo);
            double hiD = getDistance(Ax + (Bx - Ax) * hi, Cx + (Dx - Cx) * hi, Ay + (By - Ay) * hi, Cy + (Dy - Cy) * hi);

            if (loD < hiD) {
                max = hi;
            } else {
                min = lo;
            }
        }

        System.out.println(
            Math.min(
                getDistance(Ax + (Bx - Ax) * min, Cx + (Dx - Cx) * min, Ay + (By - Ay) * min, Cy + (Dy - Cy) * min),
                getDistance(Ax + (Bx - Ax) * max, Cx + (Dx - Cx) * max, Ay + (By - Ay) * max, Cy + (Dy - Cy) * max)
            )
        );
    }

    static double getDistance(double x1, double x2, double y1, double y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }
}