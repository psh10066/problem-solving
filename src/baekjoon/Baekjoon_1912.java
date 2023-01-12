package baekjoon;

import java.util.Scanner;

public class Baekjoon_1912 {
    static int[] values;
    static int[] data;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        values = new int[n + 1];
        data = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            values[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            data[i] = values[i];
            if (data[i - 1] > 0) {
                data[i] += data[i - 1];
            }
        }

        int max = data[1];
        for (int i = 2; i <= n; i++) {
            max = Math.max(max, data[i]);
        }
        System.out.println(max);
    }
}