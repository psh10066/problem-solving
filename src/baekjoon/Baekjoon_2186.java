package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_2186 {
    static int n;
    static int m;
    static int k;
    static char[] word;
    static char[][] chars;
    static int[][][] dp;
    static int[] ny = {0, 0, 1, -1};
    static int[] nx = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        chars = new char[n][m];
        for (int i = 0; i < n; i++) {
            chars[i] = br.readLine().toCharArray();
        }

        word = br.readLine().toCharArray();

        dp = new int[n][m][word.length];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (chars[i][j] == word[0]) {
                    count += dfs(i, j, 1);
                }
            }
        }
        System.out.println(count);
    }

    public static int dfs(int by, int bx, int index) {
        if (index == word.length) {
            return 1;
        }
        if (dp[by][bx][index] != -1) {
            return dp[by][bx][index];
        }

        int count = 0;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < 4; j++) {
                int y = by + ny[j] * i;
                int x = bx + nx[j] * i;

                if (y < 0 || y >= n || x < 0 || x >= m || chars[y][x] != word[index]) {
                    continue;
                }
                count += dfs(y, x, index + 1);
            }
        }

        return dp[by][bx][index] = count;
    }
}