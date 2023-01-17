package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        char before = '(';
        int stick = 0;
        int result = 0;
        for (int i = 1; i < input.length(); i++) {
            char charI = input.charAt(i);
            if (before == '(' && charI == ')') {
                result += stick;
            } else if (before == '(' && charI == '('){
                stick++;
            } else if (before == ')' && charI == ')'){
                result++;
                stick--;
            }
            before = charI;
        }
        System.out.println(result);
    }
}