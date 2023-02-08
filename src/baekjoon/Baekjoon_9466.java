package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_9466 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            int[] choices = new int[n + 1];
            int[] indexes = new int[n + 1];
            int[] teams = new int[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                choices[j] = Integer.parseInt(st.nextToken());
            }

            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (teams[j] > 0) continue;

                int student = j;
                for (int k = 0;; k++) {
                    if (teams[student] > 0) {
                        count += teams[student] == j ? indexes[student] : k;
                        break;
                    }
                    indexes[student] = k;
                    teams[student] = j;
                    if (choices[student] == student) {
                        count += k;
                        break;
                    }
                    student = choices[student];
                }
            }
            System.out.println(count);
        }
    }
}