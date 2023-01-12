package baekjoon;

import java.util.Scanner;

public class Baekjoon_11054 {
    static int[] values;
    static int[] up;
    static int[] down;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        values = new int[n + 1];
        up = new int[n + 1];
        down = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            values[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            up[i] = 1;
            for (int j = 1; j < i; j++) {
                if (values[j] < values[i]) {
                    up[i] = Math.max(up[i], up[j] + 1);
                }
            }
        }
        for (int i = n; i >= 1; i--) {
            down[i] = 1;
            for (int j = n; j > i; j--) {
                if (values[j] < values[i]) {
                    down[i] = Math.max(down[i], down[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, up[i] + down[i] - 1);
        }
        System.out.println(max);
    }
}