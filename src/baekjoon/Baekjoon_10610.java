package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon_10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int[] arr = new int[str.length()];

        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i) - '0';
            sum += arr[i];
        }

        if (sum % 3 != 0) {
            System.out.println(-1);
        } else {
            Arrays.sort(arr);
            if (arr[0] != 0) {
                System.out.println(-1);
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = str.length() - 1; i >= 0; i--) {
                    sb.append(arr[i]);
                }
                System.out.println(sb);
            }
        }
    }
}