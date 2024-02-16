package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_7453 {
    static int n;
    static int n2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        n2 = n * n;

        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        int[] d = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum1 = getSum(a, b);
        int[] sum2 = getSum(c, d);

        long count = 0;
        int i1 = 0;
        int i2 = n2 - 1;

        while (i1 < n2 && i2 >= 0) {
            int x1 = sum1[i1];
            int x2 = sum2[i2];
            int sum = x1 + x2;

            if (sum == 0) {
                long count1 = 0;
                long count2 = 0;
                while (i1 < n2 && sum1[i1] == x1) {
                    count1++;
                    i1++;
                }
                while (i2 >= 0 && sum2[i2] == x2) {
                    count2++;
                    i2--;
                }
                count += count1 * count2;
            } else if (sum < 0) {
                i1++;
            } else {
                i2--;
            }
        }

        System.out.println(count);
    }

    static int[] getSum(int[] arr1, int[] arr2) {
        int[] sum = new int[n2];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum[count++] = arr1[i] + arr2[j];
            }
        }
        Arrays.sort(sum);
        return sum;
    }
}