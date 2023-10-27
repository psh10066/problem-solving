package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon_6549_3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(getArea(arr)).append("\n");
        }

        System.out.print(sb);
    }

    static long getArea(int[] arr) {
        long area = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                int height = arr[stack.pop()];

                int width = stack.isEmpty() ? i : i - 1 - stack.peek();
                area = Math.max(area, (long) height * width);
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int height = arr[stack.pop()];

            int width = stack.isEmpty() ? arr.length : arr.length - 1 - stack.peek();
            area = Math.max(area, (long) height * width);
        }

        return area;
    }
}