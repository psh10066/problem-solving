package baekjoon;

import java.util.Scanner;

public class Baekjoon_11022 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 1; i <= t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println("Case #" + i + ": " + a + " + " + b + " = " + (a + b));
        }

        in.close();
    }
}