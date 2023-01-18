package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon_2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());

        long t = 0;
        for (int i = 0; i < n.length(); i++) {
            char charI = n.charAt(i);
            int ti = charI >= 'A' ? charI - 'A' + 10 : charI - '0';
            t += ti * Math.pow(b, n.length() - i - 1);
        }

        StringBuilder sb = new StringBuilder();
        bw.write(sb.append(t).append("\n").toString());
        bw.flush();
        bw.close();
        br.close();
    }
}