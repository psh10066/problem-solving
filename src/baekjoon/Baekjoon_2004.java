package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon_2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int nbm = n - m;

        int two = getJ(n, 2) - getJ(nbm, 2) - getJ(m, 2);
        int five = getJ(n, 5) - getJ(nbm, 5) - getJ(m, 5);

        bw.write(Math.min(two, five) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int getJ(int n, int j) {
        int count = 0;
        while (n >= j) {
            count += n / j;
            n /= j;
        }
        return count;
    }
}