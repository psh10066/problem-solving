package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        Integer[] arr = new Integer[26];

        for (int i = 0; i < s.length(); i++) {
            char charI = s.charAt(i);
            int index = charI - 'a';
            if (arr[index] == null) {
                arr[index] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append(arr[i] != null ? arr[i] : -1).append(" ");
        }
        System.out.println(sb);
    }
}