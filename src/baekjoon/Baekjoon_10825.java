package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_10825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[][] data = new String[n][4];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                data[i][j] = st.nextToken();
            }
        }

        Arrays.sort(data, (e1, e2) -> {
            if (!e1[1].equals(e2[1])) return Integer.parseInt(e2[1]) - Integer.parseInt(e1[1]);
            if (!e1[2].equals(e2[2])) return Integer.parseInt(e1[2]) - Integer.parseInt(e2[2]);
            if (!e1[3].equals(e2[3])) return Integer.parseInt(e2[3]) - Integer.parseInt(e1[3]);
            for (int i = 0; i < e1[0].length(); i++) {
                char e1Name = e1[0].charAt(i);
                char e2Name = e2[0].charAt(i);
                if (e1Name != e2Name) return e1Name - e2Name;
            }
            return e1[0].length() - e2[0].length();
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(data[i][0]).append("\n");
        }
        System.out.println(sb);
    }
}