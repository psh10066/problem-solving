package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char charI = s.charAt(i);
            if (charI >= 'A' && charI <= 'Z') {
                charI = (char) (charI + 13);
                if (charI > 'Z') {
                    charI = (char) (charI - 26);
                }
            } else if (charI >= 'a' && charI <= 'z') {
                charI = (char) (charI + 13);
                if (charI > 'z') {
                    charI = (char) (charI - 26);
                }
            }
            sb.append(charI);
        }
        System.out.println(sb);
    }
}