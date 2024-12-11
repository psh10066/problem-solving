package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_7795 {

    static int n;
    static int m;
    static int[] a;
    static int[] b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            input(br);
            solve();
        }
    }

    static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        a = new int[n];

        m = Integer.parseInt(st.nextToken());
        b = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(b);
    }

    static void solve() {
        long count = 0;

        for (int i = 0; i < n; i++) {
            count += lowerBound(i);
        }

        System.out.println(count);
    }

    static int lowerBound(int i) {
        int start = 0;
        int end = m - 1;
        int count = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (b[mid] < a[i]) {
                count = mid + 1;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return count;
    }
}