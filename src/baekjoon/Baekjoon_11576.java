package baekjoon;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon_11576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int num = 0;
        for (int i = m - 1; i >= 0; i--) {
            int input = Integer.parseInt(st.nextToken());
            num += input * Math.pow(A, i);
        }

        Stack<Integer> stack = new Stack<>();
        while (num > 0) {
            stack.push(num % B);
            num /= B;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        bw.write(sb.append("\n").toString());
        bw.flush();
        bw.close();
        br.close();
    }
}