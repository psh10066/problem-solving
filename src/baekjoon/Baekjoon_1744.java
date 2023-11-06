package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int sum = 0;
        int i, j;
        for (i = 0; i < n - 1 && arr[i + 1] < 1; i += 2) {
            sum += arr[i] * arr[i + 1];
        }
        for (j = n - 1; j > i && arr[j - 1] > 1; j -= 2) {
            sum += arr[j] * arr[j - 1];
        }
        for (; i <= j; i++) {
            sum += arr[i];
        }

        System.out.println(sum);
    }
}