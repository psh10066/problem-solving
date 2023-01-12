package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());

        System.out.println(go(x, 0));
    }

    private static int go(int x, int count) {
        if (x < 2) return count;
        count++;
        int x2 = go(x / 2, count + x % 2);
        int x3 = go(x / 3, count + x % 3);
        return Math.min(x2, x3);
    }
}