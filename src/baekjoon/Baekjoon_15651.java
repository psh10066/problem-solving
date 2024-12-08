package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_15651 {

    static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;
    static int[] selected;

    public static void main(String[] args) throws IOException {
        input();

        rec(1);
        System.out.println(sb);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        selected = new int[n + 1];
    }

    static void rec(int count) {
        if (count <= m) {
            for (int i = 1; i <= n; i++) {
                selected[count] = i;
                rec(count + 1);
            }
        } else {
            for (int i = 1; i <= m; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        }
    }
}