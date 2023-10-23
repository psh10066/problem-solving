package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1517_1 {
    static int[] arr;
    static int[] sorted;
    static long count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        sorted = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, arr.length - 1);

        System.out.println(count);
    }

    private static void mergeSort(int left, int right) {
        if (left == right) return;

        int mid = (left + right) / 2;

        mergeSort(left, mid);
        mergeSort(mid + 1, right);

        merge(left, mid, right);
    }

    private static void merge(int left, int mid, int right) {
        int a = left;
        int b = mid + 1;
        int index = left;

        while (a <= mid && b <= right) {
            if (arr[a] <= arr[b]) {
                sorted[index++] = arr[a++];
            } else {
                sorted[index++] = arr[b++];
                count += b - index;
            }
        }

        if (a <= mid) {
            for (int i = a; i <= mid; i++) {
                sorted[index++] = arr[i];
            }
        } else {
            for (int i = b; i <= right; i++) {
                sorted[index++] = arr[i];
            }
        }

        for (int i = left; i <= right; i++) {
            arr[i] = sorted[i];
        }
    }
}