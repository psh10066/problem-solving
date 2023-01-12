package baekjoon;

import java.util.Scanner;

public class Baekjoon_2522 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(n - i <= j + 1 ? "*" : " ");
            }
            System.out.println();
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(i < j ? "*" : " ");
            }
            System.out.println();
        }

        sc.close();
    }
}