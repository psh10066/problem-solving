package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_1168 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()) - 1;

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder("<");

        int index = 0;
        for (int i = 0; i < n - 1; i++) {
            index += k;
            if (index >= list.size()) {
                index %= list.size();
            }
            sb.append(list.remove(index)).append(", ");
        }

        bw.write(sb.append(list.get(0)).append(">").append("\n").toString());
        bw.flush();
        bw.close();
        br.close();
    }
}