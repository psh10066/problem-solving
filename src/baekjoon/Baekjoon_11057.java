package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_11057 {
    static Integer[][] arr = new Integer[1001][10];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            arr[1][i] = 1;
        }

        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < 10; i++) {
            count += getCount(n, i);
        }
        System.out.println(count % 10007);
    }

    static int getCount(int n, int i) {
        if (arr[n][i] != null) return arr[n][i];
        int count = 0;
        for (int j = i; j < 10; j++) {
            count += getCount(n - 1, j);
        }
        arr[n][i] = count % 10007;
        return arr[n][i];
    }
}