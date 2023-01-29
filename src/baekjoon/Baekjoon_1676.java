package baekjoon;

import java.io.*;

public class Baekjoon_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int zero = 0;
        while (n >= 5) {
            zero += n / 5;
            n /= 5;
        }

        bw.write(zero + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}