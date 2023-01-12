package baekjoon;

import java.util.Scanner;

public class Baekjoon_10953 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            String[] split = in.next().split(",");
            System.out.println(Integer.parseInt(split[0]) + Integer.parseInt(split[1]));
        }

        in.close();
    }
}