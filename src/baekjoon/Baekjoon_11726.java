package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_11726 {
    static Integer[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        array = new Integer[Math.max(n, 2)];
        array[0] = 1;
        array[1] = 2;

        System.out.println(getCount(n));
    }

    static int getCount(int n) {
        int index = n - 1;
        if (array[index] != null) return array[index];
        return array[index] = (getCount(n - 1) + getCount(n - 2)) % 10007;
    }
}