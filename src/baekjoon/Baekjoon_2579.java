package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] amount = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            amount[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= Math.min(2, n); i++) {
            dp[i] = dp[i - 1] + amount[i];
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 3] + amount[i - 1], dp[i - 2]) + amount[i];
        }
        System.out.println(dp[n]);
    }
}