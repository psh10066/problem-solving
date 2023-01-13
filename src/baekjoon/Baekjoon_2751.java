package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[] isData = new boolean[2000001];

        for (int i = 0; i < n; i++) {
            isData[Integer.parseInt(br.readLine()) + 1000000] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2000001; i++) {
            if (isData[i]) {
                sb.append(i - 1000000).append("\n");
            }
        }
        System.out.println(sb);
    }
}