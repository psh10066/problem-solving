package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] sum = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int low = Integer.parseInt(st.nextToken());
            int high = Integer.parseInt(st.nextToken());
            sb.append(sum[high] - sum[low - 1]).append("\n");
        }
        System.out.println(sb);
    }
}