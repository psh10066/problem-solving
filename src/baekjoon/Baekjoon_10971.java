package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_10971 {
    static int n;
    static int[][] w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        w = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = Integer.MAX_VALUE;
        boolean[] check = new boolean[n];
        for (int i = 0; i < n; i++) {
            check[i] = true;
            int result = go(i, i, 0, 0, check);
            if (result != 0) {
                min = Math.min(min, result);
            }
            check[i] = false;
        }

        System.out.println(min);
    }

    private static int go(int i, int start, int sum, int count, boolean[] check) {
        if (count == n - 1 && w[i][start] != 0) {
            return sum + w[i][start];
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            if (check[j] || w[i][j] == 0) {
                continue;
            }
            check[j] = true;
            int result = go(j, start, sum + w[i][j], count + 1, check);
            if (result != 0) {
                min = Math.min(min, result);
            }
            check[j] = false;
        }
        return min;
    }
}