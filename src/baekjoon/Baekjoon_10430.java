package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon_10430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        bw.write(new StringBuilder()
            .append( (a + b) % c ).append("\n")
            .append( (((a % c) + (b % c)) % c) ).append("\n")
            .append( (a * b) % c ).append("\n")
            .append( ((a % c) * (b % c)) % c ).append("\n")
            .toString());
        bw.flush();
        bw.close();
        br.close();
    }
}