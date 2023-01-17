package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon_1850 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long temp;
        if (a < b) {
            temp = a;
            a = b;
            b = temp;
        }
        while (b > 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a; i++) {
            sb.append(1);
        }

        bw.write(sb.append("\n").toString());
        bw.flush();
        bw.close();
        br.close();
    }
}