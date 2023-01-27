package baekjoon;

import java.io.*;

public class Baekjoon_11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (n != 1) {
            for (int i = 2; i <= n; i++) {
                if (n % i == 0) {
                    sb.append(i).append("\n");
                    n /= i;
                    break;
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}