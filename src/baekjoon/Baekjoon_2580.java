package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_2580 {
    static int[][] sudoku = new int[9][9];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        go(0, 0);
    }

    static void go(int y, int x) {
        if (x == 9) {
            go(y + 1, 0);
            return;
        }
        if (y == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(sudoku[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }
        if (sudoku[y][x] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (possible(y, x, i)) {
                    sudoku[y][x] = i;
                    go(y, x + 1);
                }
            }
            sudoku[y][x] = 0;
            return;
        }
        go(y, x + 1);
    }

    static boolean possible(int y, int x, int value) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[y][i] == value || sudoku[i][x] == value) {
                return false;
            }
        }
        y = y / 3 * 3;
        x = x / 3 * 3;
        for (int i = y; i < y + 3; i++) {
            for (int j = x; j < x + 3; j++) {
                if (sudoku[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}