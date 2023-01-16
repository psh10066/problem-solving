package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baekjoon_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] data = new int[n][2];
        String[] name = new String[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            data[i][0] = i;
            data[i][1] = Integer.parseInt(st.nextToken());
            name[i] = st.nextToken();
        }

        Arrays.sort(data, Comparator.comparingInt(e -> e[1]));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(data[i][1]).append(" ").append(name[data[i][0]]).append("\n");
        }
        System.out.println(sb);
    }
}