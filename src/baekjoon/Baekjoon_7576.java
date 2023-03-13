package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];

        Queue<Tomato> queue = new LinkedList();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    queue.add(new Tomato(i, j));
                }
            }
        }

        int[] arrY = {1, -1, 0, 0};
        int[] arrX = {0, 0, 1, -1};

        int last = 1;
        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = tomato.y + arrY[i];
                int nx = tomato.x + arrX[i];
                if (ny >= 0 && nx >= 0 && ny < n && nx < m) {
                    if (arr[ny][nx] == 0) {
                        arr[ny][nx] = arr[tomato.y][tomato.x] + 1;
                        queue.add(new Tomato(ny, nx));
                        last = arr[ny][nx];
                    }
                }
            }
        }

        loop: for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    last = 0;
                    break loop;
                }
            }
        }

        System.out.println(last - 1);
    }
}

class Tomato {
    int y;
    int x;

    Tomato(int y, int x) {
        this.y = y;
        this.x = x;
    }
}