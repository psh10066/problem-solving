package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_1208 {

    static int[] arr;
    static List<Integer> sumList1 = new ArrayList<>();
    static List<Integer> sumList2 = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        getSumList(0, 0, n / 2, sumList1);
        getSumList(0, n / 2, n, sumList2);

        Collections.sort(sumList1);
        Collections.sort(sumList2);

        long count = 0;

        // 투 포인터
        int i1 = 0;
        int i2 = sumList2.size() - 1;

        while (i1 < sumList1.size() && i2 >= 0) {
            int x1 = sumList1.get(i1);
            int x2 = sumList2.get(i2);

            if (x1 + x2 == s) {
                long count1 = 0;
                long count2 = 0;
                while (i1 < sumList1.size() && sumList1.get(i1) == x1) {
                    count1++;
                    i1++;
                }
                while (i2 >= 0 && sumList2.get(i2) == x2) {
                    count2++;
                    i2--;
                }
                count += count1 * count2;
            } else if (x1 + x2 > s) {
                i2--;
            } else {
                i1++;
            }
        }

        if (s == 0) {
            count--;
        }
        System.out.println(count);
    }

    static void getSumList(int sum, int start, int end, List<Integer> sumList) {
        if (start == end) {
            sumList.add(sum);
            return;
        }
        getSumList(sum + arr[start], start + 1, end, sumList);
        getSumList(sum, start + 1, end, sumList);
    }
}