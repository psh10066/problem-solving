package codility;

import java.util.HashSet;
import java.util.Set;

public class Codility_Peaks {

public int solution(int[] A) {
    int N = A.length;
    if (N < 3) {
        return 0;
    }

    int[] beforePeakCount = new int[N];

    int peakCount = 0;
    for (int i = 1; i < N - 1; i++) {
        if (A[i - 1] < A[i] && A[i + 1] < A[i]) {
            peakCount++;
        }
        beforePeakCount[i] = peakCount;
    }
    beforePeakCount[N - 1] = beforePeakCount[N - 2];

    if (peakCount == 0) {
        return 0;
    }

    for (int i = peakCount; i > 0; i--) {
        if (N % i != 0) {
            continue;
        }

        Set<Integer> peakCounts = new HashSet<>();
        for (int j = N - 1; j >= 0; j -= N / i) {
            peakCounts.add(beforePeakCount[j]);
        }

        if (peakCounts.size() == i) {
            return i;
        }
    }

    return 0;
}
}
