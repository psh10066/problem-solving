package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[k];
        long min = 0;
        long max = 0;
        long mid;

        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        // 구하고자 하는 값이 개수를 "초과하는 최촛값 - 1"이므로 max + 1의 범위 내에서 구해야 함
        max++;

        while (min < max) {
            mid = (min + max) / 2;

            long count = 0;
            for (int i = 0; i < k; i++) {
                count += arr[i] / mid;
            }

            // n과 같은 경우에도 그 중 최댓값을 구해야 하므로 min의 값을 올린다.
            if (count < n) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }
}