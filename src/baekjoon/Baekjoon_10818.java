package baekjoon;

import java.util.Scanner;

public class Baekjoon_10818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int max = sc.nextInt();
        int min = max;

        for (int i = 1; i < n; i++) {
            int d = sc.nextInt();
            if (d > max) max = d;
            if (d < min) min = d;
        }

        System.out.println(min + " " + max);

        sc.close();
    }
}