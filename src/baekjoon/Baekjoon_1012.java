package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1012 {

    static int M;
    static int N;

    static boolean[][] exists = new boolean[M][N];
    static boolean[][] checked = new boolean[M][N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] answers = new int[T];

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            exists = new boolean[M][N];
            checked = new boolean[M][N];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                exists[x][y] = true;
            }

            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (exists[x][y] && !checked[x][y]) {
                        answers[tc]++;
                        check(x, y);
                    }
                }
            }
        }

        for (int i = 0; i < answers.length; i++) {
            System.out.println(answers[i]);
        }
    }

    static int[] nx = {0, 0, 1, -1};
    static int[] ny = {1, -1, 0, 0};

    static void check(int x, int y) {
        if (x < 0 || x >= M || y < 0 || y >= N || checked[x][y]) {
            return;
        }
        if (exists[x][y]) {
            checked[x][y] = true;
            for (int i = 0; i < 4; i++) {
                check(x + nx[i], y + ny[i]);
            }
        }
    }
}