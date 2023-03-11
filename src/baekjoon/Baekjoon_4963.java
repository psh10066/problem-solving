package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_4963 {
    static int w;
    static int h;
    static int[][] arr;
    static boolean[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) return;

            arr = new int[h][w];
            check = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == 1 && !check[i][j]) {
                        count++;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void dfs(int i, int j) {
        check[i][j] = true;
        if (arr[i][j] == 1) {
            for (int ii = Math.max(i - 1, 0); ii <= Math.min(i + 1, h - 1); ii++) {
                for (int jj = Math.max(j - 1, 0); jj <= Math.min(j + 1, w - 1); jj++) {
                    if (!check[ii][jj]) dfs(ii, jj);
                }
            }
        }
    }
}