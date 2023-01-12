package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_2225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] data = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            data[i][1] = 1;
            for (int j = 2; j <= k; j++) {
                for (int l = 0; l <= i; l++) {
                    data[i][j] = (data[i][j] + data[l][j - 1]) % 1000000000;
                }
            }
        }
        System.out.println(data[n][k]);
    }
}