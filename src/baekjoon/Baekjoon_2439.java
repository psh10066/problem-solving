package baekjoon;

import java.util.Scanner;

public class Baekjoon_2439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = n; j >= 1; j--) {
                System.out.print(i >= j ? "*" : " ");
            }
            System.out.println();
        }

        sc.close();
    }
}