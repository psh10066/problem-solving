package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        String strN = String.valueOf(n);
        int distance = Math.abs(n - 100);

        if (m == 0) {
            System.out.println(Math.min(distance, strN.length()));
            return;
        }

        boolean[] arr = new boolean[10];
        StringTokenizer st = new StringTokenizer(br.readLine());

        if (m == 10 || distance <= strN.length()) {
            System.out.println(distance);
            return;
        }

        for (int i = 0; i < m; i++) {
            arr[Integer.parseInt(st.nextToken())] = true;
        }

        loop:
        for (int i = n; i - n < distance; i++) {
            String strI = String.valueOf(i);
            for (int j = 0; j < strI.length(); j++) {
                if (arr[strI.charAt(j) - '0']) {
                    continue loop;
                }
            }
            distance = Math.min(distance, strI.length() + i - n);
            break;
        }

        loop:
        for (int i = n; i >= 0 && n - i < distance; i--) {
            String strI = String.valueOf(i);
            for (int j = 0; j < strI.length(); j++) {
                if (arr[strI.charAt(j) - '0']) {
                    continue loop;
                }
            }
            distance = Math.min(distance, strI.length() + n - i);
            break;
        }

        System.out.println(distance);
    }
}