package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1783 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        switch (n) {
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(Math.min(4, (m + 1) / 2));
                break;
            default:
                System.out.println(m <= 6 ? Math.min(4, m) : m - 2);
                break;
        }
    }
}