package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_6549_2 {
    static int n;
    static int[] arr;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            arr = new int[n];
            tree = new int[n * 4];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            setTree(0, n - 1, 1);
            sb.append(getArea(0, n - 1)).append("\n");
        }

        System.out.print(sb);
    }

    static int setTree(int lo, int hi, int index) {
        if (lo == hi) {
            tree[index] = lo;
            return tree[index];
        }

        int mid = (lo + hi) / 2;

        int loIndex = setTree(lo, mid, index * 2);
        int hiIndex = setTree(mid + 1, hi, index * 2 + 1);

        tree[index] = arr[loIndex] < arr[hiIndex] ? loIndex : hiIndex;

        return tree[index];
    }

    static Integer getIndex(int lo, int hi, int index, int left, int right) {
        if (lo > right || hi < left) {
            return null;
        }
        if (lo >= left && hi <= right) {
            return tree[index];
        }

        int mid = (lo + hi) / 2;

        Integer loIndex = getIndex(lo, mid, index * 2, left, right);
        Integer hiIndex = getIndex(mid + 1, hi, index * 2 + 1, left, right);

        return loIndex != null && (hiIndex == null || arr[loIndex] < arr[hiIndex]) ? loIndex : hiIndex;
    }

    static long getArea(int lo, int hi) {
        int index = getIndex(0, n - 1, 1, lo, hi);
        long area = (long) (hi - lo + 1) * arr[index];

        if (lo < index) {
            area = Math.max(area, getArea(lo, index - 1));
        }
        if (hi > index) {
            area = Math.max(area, getArea(index + 1, hi));
        }

        return area;
    }
}