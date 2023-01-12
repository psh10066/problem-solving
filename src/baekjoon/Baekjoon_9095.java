package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_9095 {
    static Integer[] arr = new Integer[]{1, 2, 4, null, null, null, null, null, null, null};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(getCount(n));
        }
    }

    static int getCount(int n) {
        int index = n - 1;
        if (arr[index] != null) return arr[index];
        arr[index] = getCount(n - 1) + getCount(n - 2) + getCount(n - 3);
        return arr[index];
    }
}