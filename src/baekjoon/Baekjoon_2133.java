package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2133 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] data = new int[n + 1];

        if (n > 1) {
            data[2] = 3;
        }

        for (int i = 4; i <= n; i += 2) {
            data[i] += 3 * data[i - 2] + 2;
            for (int j = 4; j < i; j += 2) {
                data[i] += 2 * data[i - j];
            }
        }

        System.out.println(data[n]);
    }
}