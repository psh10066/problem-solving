package programmers;

import java.util.PriorityQueue;
import java.util.Queue;

public class Programmers_142085 {
    public int solution(int n, int k, int[] enemy) {
        if (enemy.length < k) {
            return enemy.length;
        }

        Queue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            queue.add(enemy[i]);
        }

        int sum = 0;
        for (int i = k; i < enemy.length; i++) {
            queue.add(enemy[i]);
            sum += queue.poll();

            if (sum > n) {
                return i;
            }
        }

        return enemy.length;
    }
}
