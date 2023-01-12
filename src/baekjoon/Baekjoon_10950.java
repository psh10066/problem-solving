package baekjoon;

import java.util.Scanner;

public class Baekjoon_10950 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] answer = new int[t];

        for (int i = 0; i < t; i++) {
            answer[i] = in.nextInt() + in.nextInt();
        }
        for (int i = 0; i < t; i++) {
            System.out.println(answer[i]);
        }

        in.close();
    }
}