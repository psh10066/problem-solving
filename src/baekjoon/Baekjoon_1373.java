package baekjoon;

import java.io.*;

public class Baekjoon_1373 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int s3 = s.length() % 3;
        int[] x = new int[]{4, 2, 1};

        int now = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                now += x[(i + 3 - s3) % 3];
            }
            if ((i + 1) % 3 == s3 || i + 1 == s.length()) {
                sb.append(now);
                now = 0;
            }
        }

        bw.write(sb.append("\n").toString());
        bw.flush();
        bw.close();
        br.close();
    }
}