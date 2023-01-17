package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if (input.length() % 2 != 0) {
                sb.append("NO").append("\n");
                continue;
            }
            int cnt = 0;
            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);
                switch (c) {
                    case '(' -> cnt++;
                    case ')' -> cnt--;
                }
                if (cnt < 0) break;
            }
            sb.append(cnt == 0 ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }
}