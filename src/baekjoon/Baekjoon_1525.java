package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Baekjoon_1525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            s.append(br.readLine().replace(" ", ""));
        }

        if (s.toString().equals("123456780")) {
            System.out.println(0);
            return;
        }

        Map<String, Integer> map = new HashMap<>();
        map.put(s.toString(), 0);

        int[] nx = {0, 0, 1, -1};
        int[] ny = {1, -1, 0, 0};

        Queue<String> queue = new LinkedList<>();
        queue.add(s.toString());

        while (!queue.isEmpty()) {
            StringBuilder before = new StringBuilder(queue.poll());
            int cnt = map.get(before.toString()) + 1;
            int zeroIndex = before.indexOf("0");

            for (int i = 0; i < 4; i++) {
                int x = zeroIndex / 3 + nx[i];
                int y = zeroIndex % 3 + ny[i];
                int toIndex = x * 3 + y;

                if (x < 0 || x > 2 || y < 0 || y > 2) continue;
                StringBuilder sb = new StringBuilder(before);
                sb.setCharAt(zeroIndex, sb.charAt(toIndex));
                sb.setCharAt(toIndex, '0');

                if (map.containsKey(sb.toString())) {
                    continue;
                }

                if (sb.toString().equals("123456780")) {
                    System.out.println(cnt);
                    return;
                }

                map.put(sb.toString(), cnt);
                queue.add(sb.toString());
            }
        }

        System.out.println(-1);
    }
}