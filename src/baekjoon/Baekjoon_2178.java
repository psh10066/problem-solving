package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        int[] arrY = {0, 0, 1, -1};
        int[] arrX = {1, -1, 0, 0};

        while (!queue.isEmpty()) {
            int[] ints = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = ints[0] + arrY[i];
                int nx = ints[1] + arrX[i];

                if (ny >= 0 && nx >= 0 && ny < n && nx < m) {
                    if (arr[ny][nx] == 1) {
                        arr[ny][nx] = arr[ints[0]][ints[1]] + 1;

                        if (ny == n - 1 && nx == m - 1) {
                            System.out.println(arr[ny][nx]);
                            return;
                        }

                        queue.add(new int[]{ny, nx});
                    }
                }
            }
        }
    }
}