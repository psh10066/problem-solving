package codility;

import java.util.Arrays;

public class Codility_MaxCounters {
    public int[] solution(int N, int[] A) {
        // N : 카운터 개수
        int[] counters = new int[N];
        int maxCounter = 0;
        int keepedCounter = 0;

        for (int value : A) {
            if (value >= 1 && value <= N) {
                int targetIndex = value - 1;
                counters[targetIndex]++;
                maxCounter = Math.max(maxCounter, counters[targetIndex]);
            } else if (value == N + 1) {
                keepedCounter += maxCounter;
                maxCounter = 0;
                counters = new int[N];
            }
        }

        for (int i = 0; i < N; i++) {
            counters[i] += keepedCounter;
        }
        return counters;
    }
}
