package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Baekjoon_1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n < 2) {
            System.out.println(0);
            return;
        }

        boolean[] isPrimeNumber = new boolean[n + 1];
        Arrays.fill(isPrimeNumber, true);
        isPrimeNumber[0] = isPrimeNumber[1] = false;

        List<Integer> primeNumberList = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (isPrimeNumber[i]) {
                primeNumberList.add(i);
                for (int j = 2; i * j <= n; j++) {
                    isPrimeNumber[i * j] = false;
                }
            }
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;

        while (true) {
            if (sum >= n) {
                if (sum == n) {
                    count++;
                }
                sum -= primeNumberList.get(start++);
            } else if (end == primeNumberList.size()) {
                break;
            } else {
                sum += primeNumberList.get(end++);
            }
        }

        System.out.println(count);
    }
}