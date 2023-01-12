package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2193 {
    static Long[][] arr = new Long[91][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr[1][0] = 1L;
        arr[1][1] = 1L;

        int n = Integer.parseInt(br.readLine());

        long count = getCount(n, 1);
        System.out.println(count);
    }

    static long getCount(int n, int i) {
        if (arr[n][i] != null) return arr[n][i];
        arr[n][i] = getCount(n - 1, 0);
        if (i == 0) {
            arr[n][i] += getCount(n - 1, 1);
        }
        return arr[n][i];
    }
}