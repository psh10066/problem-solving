package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_2143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n + 1];
        int[] aSum = new int[n * (n + 1) / 2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        // 누적 합
        for (int i = 1; i < n; i++) {
            a[i] = a[i] + a[i - 1];
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int x = a[j];
                if (i > 0) {
                    x -= a[i - 1];
                }
                aSum[index++] = x;
            }
        }

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m + 1];
        int[] bSum = new int[m * (m + 1) / 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        // 누적 합
        for (int i = 1; i < m; i++) {
            b[i] = b[i] + b[i - 1];
        }

        index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                int x = b[j];
                if (i > 0) {
                    x -= b[i - 1];
                }
                bSum[index++] = x;
            }
        }

        Arrays.sort(aSum);
        Arrays.sort(bSum);

        long count = 0;
        int i1 = 0;
        int i2 = bSum.length - 1;
        while (i1 < aSum.length && i2 >= 0) {
            int x1 = aSum[i1];
            int x2 = bSum[i2];
            int sum = x1 + x2;
            if (sum == t) {
                long countA = 0;
                long countB = 0;
                while (i1 < aSum.length && aSum[i1] == x1) {
                    countA++;
                    i1++;
                }
                while (i2 >= 0 && bSum[i2] == x2) {
                    countB++;
                    i2--;
                }
                count += countA * countB;
            } else if (sum > t) {
                i2--;
            } else {
                i1++;
            }
        }
        System.out.println(count);
    }
}