package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2011 {
    static String pw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        pw = br.readLine();

        int[] data = new int[pw.length() + 1];
        data[1] = check(1, 1) ? 1 : 0;
        if (pw.length() > 1) {
            if (!check(2, 1)) {
                data[2] = 0;
            } else {
                data[2] = check(2, 2) ? data[1] + 1 : data[1];
            }
        }
        for (int i = 3; i <= pw.length(); i++) {
            if (!check(i, 1)) {
                data[i] = 0;
                continue;
            }
            data[i] = (data[i - 1] + (check(i, 2) ? data[i - 2] : 0)) % 1000000;
        }
        System.out.println(data[pw.length()]);
    }

    static boolean check(int n, int length) {
        int index = pw.length() - n;
        int num = Integer.parseInt(pw.substring(index, Math.min(index + length, pw.length())));
        return num >= 1 && num <= 26;
    }
}