package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baekjoon_10819 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int midIndex = n / 2;

        Arrays.sort(arr);
        int asc = arr[midIndex] - arr[0];

        for (int i = n - 1; i > midIndex; i--) {
            for (int j = 0; j < 2; j++) {
                int index = n - 1 - i + j;
                if (index == midIndex) break;
                asc += arr[i] - arr[index];
            }
        }

        Arrays.sort(arr, Comparator.reverseOrder());
        int desc = arr[0] - arr[midIndex];

        for (int i = n - 1; i > midIndex; i--) {
            for (int j = 0; j < 2; j++) {
                int index = n - 1 - i + j;
                if (index == midIndex) break;
                desc += arr[index] - arr[i];
            }
        }

        System.out.println(Math.max(asc, desc));
    }
}