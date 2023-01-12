package baekjoon;

import java.util.Scanner;

public class Baekjoon_2445 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n; j++) {
                System.out.print(i >= j || 2 * n - 1 <= i + j ? "*" : " ");
            }
            System.out.println();
        }
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < 2 * n; j++) {
                System.out.print(i > j || 2 * n - 1 < i + j ? "*" : " ");
            }
            System.out.println();
        }

        sc.close();
    }
}