package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] data = new long[101];
        data[1] = 1;
        data[2] = 1;
        data[3] = 1;
        data[4] = 2;
        data[5] = 2;
        for (int i = 6; i <= 100; i++) {
            data[i] = data[i - 1] + data[i - 5];
        }

        int t = Integer.parseInt(br.readLine());
        long[] answers = new long[t];
        for (int i = 0; i < t; i++) {
            answers[i] = data[Integer.parseInt(br.readLine())];
        }
        for (int i = 0; i < t; i++) {
            System.out.println(answers[i]);
        }
    }
}