package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baekjoon_1517_2 {
    static int[] arr;
    static int[] sortedArr;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = sortedArr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        Map<Integer, Integer> valueToIndexMap = new HashMap<>();
        Map<Integer, Integer> valueToCountMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!valueToIndexMap.containsKey(arr[i])) {
                valueToIndexMap.put(arr[i], i);
            }
            valueToCountMap.put(arr[i], valueToCountMap.getOrDefault(arr[i], 0) + 1);
        }

        tree = new int[arr.length * 4];

        long total = 0;
        for (int i = 0; i < n; i++) {
            int index = valueToIndexMap.get(sortedArr[i]);
            int count = valueToCountMap.get(sortedArr[i]);

            total += intervalSum(0, n - 1, 1, index + 1, n - 1);
            update(0, n - 1, 1, index, count);
        }

        System.out.println(total);
    }

    private static int intervalSum(int start, int end, int index, int left, int right) {
        if (start > right || end < left) {
            return 0;
        }
        if (start >= left && end <= right) {
            return tree[index];
        }
        int mid = (start + end) / 2;
        return intervalSum(start, mid, index * 2, left, right) + intervalSum(mid + 1, end, index * 2 + 1, left, right);
    }

    private static void update(int start, int end, int index, int targetIndex, int value) {
        if (start == end) {
            tree[index] = value;
            return;
        }
        int mid = (start + end) / 2;
        if (targetIndex <= mid) {
            update(start, mid, index * 2, targetIndex, value);
        } else {
            update(mid + 1, end, index * 2 + 1, targetIndex, value);
        }
        tree[index] = tree[index * 2] + tree[index * 2 + 1];
    }
}