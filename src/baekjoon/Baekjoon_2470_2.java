package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_2470_2 {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        input();

        int v1 = 0;
        int v2 = 0;
        int closest = Integer.MAX_VALUE;

        int start = 0;
        int end = n - 1;
        while (start < end) {
            int target = arr[start] + arr[end];
            int targetAbs = Math.abs(target);
            if (targetAbs < Math.abs(closest)) {
                v1 = start;
                v2 = end;
                closest = targetAbs;
            }
            if (target < 0) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(arr[v1] + " " + arr[v2]);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
    }
}