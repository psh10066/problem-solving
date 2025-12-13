package codility;

public class Codility_Flags {
    int[] nextPeak;

    public int solution(int[] A) {
        if (A.length < 3) {
            return 0;
        }

        nextPeak = new int[A.length];
        int peakCount = 0;

        for (int i = A.length - 2; i > 0; i--) {
            if (A[i - 1] < A[i] && A[i + 1] < A[i]) {
                nextPeak[i] = i;
                peakCount++;
            } else {
                nextPeak[i] = nextPeak[i + 1];
            }
        }
        nextPeak[0] = nextPeak[1];

        if (peakCount == 0) {
            return 0;
        }

        int flagCount = 1;

        for (int i = 2; i <= peakCount; i++) {
            int currentFlagCount = getFlagCount(i);
            if (currentFlagCount <= flagCount) {
                return flagCount;
            }
            flagCount = currentFlagCount;
        }
        return flagCount;
    }

    public int getFlagCount(int distance) {
        int count = 1;
        int peak = nextPeak[0];
        while (count < distance) {
            int sum = peak + distance;
            if (sum >= nextPeak.length) break;
            if (nextPeak[sum] == 0) break;
            peak = nextPeak[sum];
            count++;
        }
        return count;
    }
}
