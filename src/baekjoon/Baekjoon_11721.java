package baekjoon;

import java.util.Scanner;

public class Baekjoon_11721 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && i % 10 == 0) {
                System.out.println();
            }
            System.out.print(s.charAt(i));
        }
        sc.close();
    }
}