package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_12891 {

    static int[] answerArray = new int[4];
    static int[] countArray = new int[4];
    static int aIndex = 0;
    static int cIndex = 1;
    static int gIndex = 2;
    static int tIndex = 3;
    static int answerCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        char[] charArray = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            answerArray[i] = Integer.parseInt(st.nextToken());
            if (answerArray[i] == 0) {
                answerCount++;
            }
        }

        for (int i = 0; i < p; i++) {
            add(charArray[i]);
        }

        int result = 0;
        if (answerCount == 4) {
            result++;
        }

        for (int i = 0; i < s - p; i++) {
            remove(charArray[i]);
            add(charArray[i + p]);
            if (answerCount == 4) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static void add(char c) {
        switch (c) {
            case 'A':
                countArray[aIndex]++;
                if (answerArray[aIndex] == countArray[aIndex]) answerCount++;
                break;
            case 'C':
                countArray[cIndex]++;
                if (answerArray[cIndex] == countArray[cIndex]) answerCount++;
                break;
            case 'G':
                countArray[gIndex]++;
                if (answerArray[gIndex] == countArray[gIndex]) answerCount++;
                break;
            case 'T':
                countArray[tIndex]++;
                if (answerArray[tIndex] == countArray[tIndex]) answerCount++;
                break;
        }
    }

    private static void remove(char c) {
        switch (c) {
            case 'A':
                if (answerArray[aIndex] == countArray[aIndex]) answerCount--;
                countArray[aIndex]--;
                break;
            case 'C':
                if (answerArray[cIndex] == countArray[cIndex]) answerCount--;
                countArray[cIndex]--;
                break;
            case 'G':
                if (answerArray[gIndex] == countArray[gIndex]) answerCount--;
                countArray[gIndex]--;
                break;
            case 'T':
                if (answerArray[tIndex] == countArray[tIndex]) answerCount--;
                countArray[tIndex]--;
                break;
        }
    }
}