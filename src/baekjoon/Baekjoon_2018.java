package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int sum = 1;
        int count = 1;

        int start = 1;
        int end = 1;

        while (start <= n / 2) {
            if (sum > n) {
                sum -= start;
                start++;
                continue;
            }
            if (sum == n) {
                count++;
            }
            end++;
            sum += end;
        }

        System.out.println(count);
    }
}