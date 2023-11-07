package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1451 {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        long max = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                max = Math.max(max, (long) getSum(0, i, 0, m - 1) * getSum(i + 1, j, 0, m - 1) * getSum(j + 1, n - 1, 0, m - 1));
            }
        }

        for (int i = 0; i < m - 2; i++) {
            for (int j = i + 1; j < m - 1; j++) {
                max = Math.max(max, (long) getSum(0, n - 1, 0, i) * getSum(0, n - 1, i + 1, j) * getSum(0, n - 1, j + 1, m - 1));
            }
        }

        for (int i = 0; i < n - 1; i++) {
            int top = getSum(0, i, 0, m - 1);
            int bottom = getSum(i + 1, n - 1, 0, m - 1);
            for (int j = 0; j < m - 1; j++) {
                int topLeft = getSum(0, i, 0, j);
                int topRight = getSum(0, i, j + 1, m - 1);
                int bottomLeft = getSum(i + 1, n - 1, 0, j);
                int bottomRight = getSum(i + 1, n - 1, j + 1, m - 1);

                max = Math.max(max, (long) topLeft * topRight * bottom);
                max = Math.max(max, (long) bottomLeft * bottomRight * top);
            }
        }

        for (int j = 0; j < m - 1; j++) {
            int left = getSum(0, n - 1, 0, j);
            int right = getSum(0, n - 1, j + 1, m - 1);
            for (int i = 0; i < n - 1; i++) {
                int topLeft = getSum(0, i, 0, j);
                int bottomLeft = getSum(i + 1, n - 1, 0, j);
                int topRight = getSum(0, i, j + 1, m - 1);
                int bottomRight = getSum(i + 1, n - 1, j + 1, m - 1);

                max = Math.max(max, (long) topLeft * bottomLeft * right);
                max = Math.max(max, (long) topRight * bottomRight * left);
            }
        }

        System.out.println(max);
    }

    static int getSum(int y1, int y2, int x1, int x2) {
        int sum = 0;
        for (int i = y1; i <= y2; i++) {
            for (int j = x1; j <= x2; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }
}