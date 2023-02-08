package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_10451 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            boolean[] check = new boolean[n];
            int[] ints = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ints[j] = Integer.parseInt(st.nextToken());
            }

            int count = 0;
            for (int j = 0; j < n; j++) {
                if (check[j]) continue;
                count++;

                int index = j;
                while (!check[index]) {
                    check[index] = true;
                    index = ints[index] - 1;
                }
            }
            System.out.println(count);
        }
    }
}