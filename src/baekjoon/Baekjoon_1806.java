package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = 0;

        int answer = Integer.MAX_VALUE;
        while (true) {
            if (sum >= s) {
                answer = Math.min(answer, end - start);
                sum -= arr[start++];
            } else if (end == n) {
                break;
            } else {
                sum += arr[end++];
            }
        }
        System.out.println(answer < Integer.MAX_VALUE ? answer : 0);
    }
}