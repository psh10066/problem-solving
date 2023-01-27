package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int count = n;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(st.nextToken());
            if (t == 1) {
                count--;
                continue;
            }
            for (int j = 2; j < t; j++) {
                if (t % j == 0) {
                    count--;
                    break;
                }
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}