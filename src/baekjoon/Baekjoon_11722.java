package baekjoon;

import java.util.Scanner;

public class Baekjoon_11722 {
    static int[] values;
    static Integer[] data;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        values = new int[n + 1];
        data = new Integer[n + 1];

        for (int i = 1; i <= n; i++) {
            values[i] = sc.nextInt();
            go(i);
        }

        int max = 1;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, data[i]);
        }
        System.out.println(max);
    }

    static int go(int n) {
        if (data[n] != null) return data[n];
        data[n] = 1;
        for (int i = 1; i < n; i++) {
            if (values[i] > values[n]) {
                data[n] = Math.max(data[n], go(i) + 1);
            }
        }
        return data[n];
    }
}