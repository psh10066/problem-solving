package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_1992 {
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        go(0, 0, n);
    }

    static void go(int x, int y, int n) {
        Character c = f(x, y, n);
        if (c == null) {
            System.out.print("(");
            int n2 = n / 2;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    go(x + n2 * i, y + n2 * j, n2);
                }
            }
            System.out.print(")");
        } else {
            System.out.print(c);
        }
    }

    static Character f(int x, int y, int n) {
        Character c = null;
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