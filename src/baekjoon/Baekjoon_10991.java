package baekjoon;

import java.util.Scanner;

public class Baekjoon_10991 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int s = 0;
            for (int j = 0; j < n + i; j++) {
                if (j < n - i - 1) {
                    System.out.print(" ");
                } else {
                    System.out.print(s % 2 == 0 ? "*" : " ");
                    s++;
                }
            }
            System.out.println();
        }

        sc.close();
    }
}