package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_10844 {
    static Integer[][] arr = new Integer[101][10];
    static int MOD = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            arr[1][i] = 1;
        }

        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 1; i < 10; i++) {
            count = (count + getCount(n, i)) % MOD;
        }
        System.out.println(count);
    }

    static int getCount(int n, int x) {
        if (arr[n][x] != null) return arr[n][x];
        if (x == 9) {
            arr[n][x] = getCount(n - 1, 8) % MOD;
        } else if (x == 0) {
            arr[n][x] = getCount(n - 1, 1) % MOD;
        } else {
            arr[n][x] = (getCount(n - 1, x + 1) + getCount(n - 1, x - 1)) % MOD;
        }
        return arr[n][x];
    }
}