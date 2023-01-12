package baekjoon;

import java.util.Scanner;

public class Baekjoon_2739 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= 9; i++) {
            System.out.println(t + " * " + i + " = " + (t * i));
        }
        sc.close();
    }
}