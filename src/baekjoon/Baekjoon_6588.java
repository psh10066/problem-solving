package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon_6588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] arr = new boolean[1000001];
        List<Integer> list = new ArrayList<>();

        for (int i = 2; i <= 1000000; i++) {
            boolean is = true;
            int limit = 2;
            for (int t : list) {
                if (t > i / limit) {
                    break;
                }
                if (i % t == 0) {
                    is = false;
                    break;
                }
                limit = t;
            }
            if (is) {
                list.add(i);
                arr[i] = true;
            }
        }

        StringBuilder sb = new StringBuilder();

        int n;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            boolean is = false;
            for (int i : list) {
                if (i > n / 2) {
                    break;
                }
                if (arr[n - i]) {
                    is = true;
                    sb.append(n).append(" = ").append(i).append(" + ").append(n - i).append("\n");
                    break;
                }
            }
            if (!is) {
                sb.append("Goldbach's conjecture is wrong.").append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}