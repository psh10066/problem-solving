package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2447 {
    static Character[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new Character[n][n];
        go(0, 0, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j] != null ? arr[i][j] : ' ');
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void go(int x, int y, int n) {
        if (n == 3) {
            for (int i = x; i < x + n; i++) {
                for (int j = y; j < y + n; j++) {
                    if (i + 2 != x + n || j + 2 != y + n) {
                        arr[i][j] = '*';
                    }
                }
            }
        } else {
            int n3 = n / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i != 1 || j != 1) {
                        go(x + i * n3, y + j * n3, n3);
                    }
                }
            }
        }
    }
}