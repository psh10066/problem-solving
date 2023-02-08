package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_2331 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int[] check = new int[(int) (Math.pow(9, p) * p + 1)];

        for (int i = 1;; i++) {
            if (check[a] > 0) {
                System.out.println(check[a] - 1);
                return;
            }
            check[a] = i;

            int num = 0;
            while (a > 0) {
                num += Math.pow(a % 10, p);
                a /= 10;
            }
            a = num;
        }
    }
}