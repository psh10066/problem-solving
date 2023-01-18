package baekjoon;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon_11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Stack<String> stack = new Stack<>();

        while (n > 0) {
            int t = (int) (n % b);
            stack.push(t > 9 ? String.valueOf((char) ('A' + t - 10)) : String.valueOf(t));
            n /= b;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        bw.write(sb.append("\n").toString());
        bw.flush();
        bw.close();
        br.close();
    }
}