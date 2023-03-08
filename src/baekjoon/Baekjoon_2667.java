package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baekjoon_2667 {

    static int n;
    static char[][] arr;
    static boolean[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new char[n][n];
        check = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == '0' || check[i][j]) continue;
                list.add(dfs(i, j));
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        list.forEach(System.out::println);
    }

    static int dfs(int i, int j) {
        int count = 1;
        check[i][j] = true;

        if (i > 0 && arr[i - 1][j] == '1' && !check[i - 1][j]) count += dfs(i - 1, j);
        if (i < n - 1 && arr[i + 1][j] == '1' && !check[i + 1][j]) count += dfs(i + 1, j);
        if (j > 0 && arr[i][j - 1] == '1' && !check[i][j - 1]) count += dfs(i, j - 1);
        if (j < n - 1 && arr[i][j + 1] == '1' && !check[i][j + 1]) count += dfs(i, j + 1);

        return count;
    }
}