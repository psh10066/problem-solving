package baekjoon;

import java.io.*;

public class Baekjoon_1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        StringBuilder sb = new StringBuilder();

        int n = s.charAt(0) - '0';
        boolean f = n / 4 == 1;
        sb.append(n / 4 == 1 ? '1' : "");
        sb.append(n % 4 >= 2 ? '1' : f ? '0' : "");
        sb.append(n % 2 == 1 ? '1' : '0');

        for (int i = 1; i < s.length(); i++) {
            n = s.charAt(i) - '0';
            sb.append(n / 4 == 1 ? '1' : '0');
            sb.append(n % 4 >= 2 ? '1' : '0');
            sb.append(n % 2 == 1 ? '1' : '0');
        }

        bw.write(sb.append("\n").toString());
        bw.flush();
        bw.close();
        br.close();
    }
}