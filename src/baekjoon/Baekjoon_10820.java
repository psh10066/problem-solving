package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;
        while ((s = br.readLine()) != null) {
            int[] count = new int[4];
            for (int i = 0; i < s.length(); i++) {
                char charI = s.charAt(i);
                if (charI == ' ') count[3]++;
                else if (charI <= '9') count[2]++;
                else if (charI <= 'Z') count[1]++;
                else count[0]++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                sb.append(count[i]).append(" ");
            }
            System.out.println(sb);
        }
    }
}