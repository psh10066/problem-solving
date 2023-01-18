package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon_9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        int tmp;
        int a;
        int b;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int[] num = new int[n];
            long gcd = 0;
            for (int j = 0; j < n; j++) {
                num[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (num[j] > num[k]) {
                        a = num[j];
                        b = num[k];
                    } else {
                        a = num[k];
                        b = num[j];
                    }
                    while (b > 0) {
                        tmp = b;
                        b = a % b;
                        a = tmp;
                    }
                    gcd += a;
                }
            }
            sb.append(gcd).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}