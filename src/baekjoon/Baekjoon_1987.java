package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1987 {
    static int r;
    static int c;
    static char[][] arr;
    static boolean[] visited = new boolean[26];
    static int max;
    static int[] ny = {-1, 1, 0, 0};
    static int[] nx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];

        for (int i = 0; i < r; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        dfs(0, 0, 1);
        System.out.println(max);
    }

    static void dfs(int y, int x, int count) {
        max = Math.max(max, count);
        visited[arr[y][x] - 'A'] = true;

        for (int i = 0; i < 4; i++) {
            int yy = y + ny[i];
            int xx = x + nx[i];
            if (yy < 0 || xx < 0 || yy == r || xx == c) continue;
            if (visited[arr[yy][xx] - 'A']) continue;
            dfs(yy, xx, count + 1);
        }

        visited[arr[y][x] - 'A'] = false;
    }
}