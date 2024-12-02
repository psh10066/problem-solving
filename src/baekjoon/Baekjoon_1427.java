package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArray = br.readLine().toCharArray();
        int length = charArray.length;

        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = charArray[i] - '0';
        }

        for (int i = 0; i < length; i++) {
            int maxValue = arr[i];
            int maxIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (maxValue < arr[j]) {
                    maxValue = arr[j];
                    maxIndex = j;
                }
            }
            arr[maxIndex] = arr[i];
            arr[i] = maxValue;
        }

        for (int i = 0; i < length; i++) {
            System.out.print(arr[i]);
        }
    }
}