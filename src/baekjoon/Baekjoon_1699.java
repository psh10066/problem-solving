package baekjoon;

import java.util.Scanner;

public class Baekjoon_1699 {
    static Integer[] data;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        data = new Integer[n + 1];
        data[1] = 1;

        System.out.println(get(n));
    }

    static int get(int x) {
        if (data[x] != null) return data[x];

        data[x] = x;
        for (int j = (int) Math.sqrt(x); j >= 1; j--) {
            data[x] = Math.min(data[x], get(x - j * j) + 1);
            if (data[x] == 1) return data[x];
        }

        return data[x];
    }
}