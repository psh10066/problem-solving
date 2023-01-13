package baekjoon;

import java.util.Scanner;

public class Baekjoon_11052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] cards = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            cards[i] = sc.nextInt();
        }

        int[] data = new int[n + 1];
        data[1] = cards[1];

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                data[i] = Math.max(data[i], data[j] + cards[i - j]);
            }
        }

        System.out.println(data[n]);
    }
}