package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_6549_1 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(getArea(0, n - 1)).append("\n");
        }

        System.out.println(sb);
    }

    static long getArea(int lo, int hi) {
        if (lo == hi) {
            return arr[lo];
        }

        int mid = (lo + hi) / 2;

        return Math.max(
            Math.max(
                getArea(lo, mid),
                getArea(mid + 1, hi)
            ),
            getMidArea(lo, hi, mid)
        );
    }

    static long getMidArea(int lo, int hi, int mid) {
        long area = 0;
        int left = mid - 1;
        int right = mid + 1;
        int height = arr[mid];

        int count = 1;
        while (left >= lo && right <= hi) {
            if (arr[left] > arr[right]) {
                height = Math.min(height, arr[left--]);
            } else {
                height = Math.min(height, arr[right++]);
            }
            area = Math.max(area, (long) height * ++count);
        }

        while (left >= lo) {
            height = Math.min(height, arr[left--]);
            area = Math.max(area, (long) height * ++count);
        }

        while (right <= hi) {
            height = Math.min(height, arr[right++]);
            area = Math.max(area, (long) height * ++count);
        }

        return area;
    }
}