package baekjoon;

import java.util.Scanner;

public class Baekjoon_9465 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] costs = new int[2][n + 1];
            int[][] dps = new int[2][n + 1];

            for (int j = 0; j < 2; j++) {
                for (int k = 1; k <= n; k++) {
                    costs[j][k] = sc.nextInt();
                }
            }

            dps[0][1] = costs[0][1];
            dps[1][1] = costs[1][1];

            for (int j = 2; j <= n; j++) {
                dps[0][j] = Math.max(dps[1][j - 1], dps[1][j - 2]) + costs[0][j];
                dps[1][j] = Math.max(dps[0][j - 1], dps[0][j - 2]) + costs[1][j];
            }

            System.out.println(Math.max(dps[0][n], dps[1][n]));
        }
    }
}