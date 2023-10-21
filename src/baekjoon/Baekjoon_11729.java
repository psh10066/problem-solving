package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_11729 {
    static int count = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        go(1, 3, n);
        System.out.println(count);
        System.out.print(sb);
    }

    static void go(int start, int end, int n) {
        if (n > 1) {
            go(start, 6 - start - end, n - 1);
        }
        count++;
        sb.append(start).append(" ").append(end).append("\n");
        if (n > 1) {
            go(6 - start - end, end, n - 1);
        }
    }
}