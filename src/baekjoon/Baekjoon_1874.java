package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        int next = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int target = arr[i];
            while (next <= target) {
                sb.append("+\n");
                stack.push(next++);
            }
            if (target != stack.pop()) {
                System.out.println("NO");
                return;
            }
            sb.append("-\n");
        }
        System.out.println(sb);
    }
}