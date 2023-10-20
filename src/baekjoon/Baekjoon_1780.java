package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon_1780 {
    static int[] count = new int[3];
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        go(0, 0, n);

        for (int i = 0; i < 3; i++) {
            bw.write(count[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    static void go(int x, int y, int n) {
        Integer f = f(x, y, n);
        if (f == null) {
            int n3 = n / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    go(x + i * n3, y + j * n3, n3);
                }
            }
        } else {
            count[f + 1]++;
        }
    }

    static Integer f(int x, int y, int n) {
        Integer c = null;
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (c == null) {
                    c = arr[i][j];
                } else if (!c.equals(arr[i][j])) {
                    return null;
                }
            }
        }
        return c;
    }
}