package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_6603 {
    static int[] s;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            if (k == 0) break;

            s = new int[st.countTokens()];
            visited = new boolean[s.length];

            for (int i = 0; i < s.length; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0);
            System.out.println();
        }
    }

    static void dfs(int index) {
        if (index == s.length) return;
        visited[index] = true;

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            if (visited[i]) {
                count++;
                sb.append(s[i]).append(" ");
            }
        }
        if (count == 6) {
            System.out.println(sb);
        } else {
            dfs(index + 1);
        }

        visited[index] = false;
        dfs(index + 1);
    }
}