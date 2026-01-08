package programmers;

import java.util.Arrays;

public class Programmers_152996 {
    public long solution(int[] weights) {
        Arrays.sort(weights);

        long count = 0;
        for (int i = 0; i < weights.length - 1; i++) {
            int a = weights[i];
            for (int j = i + 1; j < weights.length; j++) {
                int b = weights[j];

                if (a == b || a * 2 == b || a * 3 == b * 2 || a * 4 == b * 3) {
                    count++;
                    continue;
                }
                if (a * 2 < b) {
                    break;
                }
            }
        }
        return count;
    }
}
