package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1759 {
    static class Point {
        String str;
        int index;
        boolean[] check;

        public Point(String str, int index, boolean[] check) {
            this.str = str;
            this.index = index;
            this.check = check;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String[] arr = new String[c];
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken();
        }
        Arrays.sort(arr);

        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i <= c - l; i++) {
            boolean[] check = new boolean[c];
            check[i] = true;
            queue.add(new Point(arr[i], i + 1, check));
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            if (point.str.length() == l) {
                int vowel = 0;
                for (int i = 0; i < l; i++) {
                    char charI = point.str.charAt(i);
                    if (charI == 'a' || charI == 'e' || charI == 'i' || charI == 'o' || charI == 'u') {
                        vowel++;
                    }
                }
                if (vowel > 0 && l - vowel > 1) {
                    sb.append(point.str).append("\n");
                }
            } else {
                for (int i = point.index; i <= c - l + point.str.length(); i++) {
                    if (!point.check[i]) {
                        boolean[] check = Arrays.copyOf(point.check, point.check.length);
                        check[i] = true;
                        queue.add(new Point(point.str + arr[i], i + 1, check));
                    }
                }
            }
        }

        System.out.println(sb);
    }
}