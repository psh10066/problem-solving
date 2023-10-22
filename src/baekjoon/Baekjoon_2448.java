package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2448 {
    static Character[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new Character[n][n * 2];
        go(0, 0, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n * 2; j++) {
                sb.append(arr[i][j] != null ? arr[i][j] : ' ');
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void go(int x, int y, int n) {
        if (n == 3) {
            arr[x][y + 2] = '*';
            arr[x + 1][y + 1] = '*';
            arr[x + 1][y + 3] = '*';
            for (int i = 0; i < 5; i++) {
                arr[x + 2][y + i] = '*';
            }
        } else {
            int n2 = n / 2;
            go(x, y + n2, n2);
            go(x + n2, y, n2);
            go(x + n2, y + n, n2);
        }
    }
}