package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_2632 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] a = new int[m];
        int[] b = new int[n];
        for (int i = 0; i < m; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(br.readLine());
        }

        List<Integer> sumA = getSumList(a);
        List<Integer> sumB = getSumList(b);

        long count = 0;
        int i1 = 0;
        int i2 = sumB.size() - 1;

        while (i1 < sumA.size() && i2 >= 0) {
            int x1 = sumA.get(i1);
            int x2 = sumB.get(i2);
            int sum = x1 + x2;
            if (sum == size) {
                long countA = 0;
                long countB = 0;
                while (i1 < sumA.size() && sumA.get(i1) == x1) {
                    countA++;
                    i1++;
                }
                while (i2 >= 0 && sumB.get(i2) == x2) {
                    countB++;
                    i2--;
                }
                count += countA * countB;
            } else if (sum < size) {
                i1++;
            } else {
                i2--;
            }
        }
        System.out.println(count);
    }

    static List<Integer> getSumList(int[] arr) {
        List<Integer> sumList = new ArrayList<>();
        sumList.add(0);
        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            sumList.add(sum);
            for (int j = i + 1; j < arr.length; j++) {
                sumList.add(sum += arr[j]);
            }
        }
        // 끝과 끝 연결
        int sum = arr[arr.length - 1];
        for (int i = 0; i < arr.length - 2; i++) {
            sum += arr[i];
            sumList.add(sum);
            int tempSum = sum;
            for (int j = arr.length - 2; j > i + 1; j--) {
                tempSum += arr[j];
                sumList.add(tempSum);
            }
        }

        Collections.sort(sumList);
        return sumList;
    }
}