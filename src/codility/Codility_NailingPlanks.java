package codility;

public class Codility_NailingPlanks {
    public int solution(int[] A, int[] B, int[] C) {
        int low = 0;
        int high = C.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (check(mid, A, B, C)) {
                result = mid + 1; // count로 저장
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    public boolean check(int maxIndex, int[] A, int[] B, int[] C) {
        int maxValue = 0;
        for (int x : B) maxValue = Math.max(maxValue, x);
        for (int x : C) maxValue = Math.max(maxValue, x);

        int[] prefixSum = new int[maxValue + 1];

        // 못 위치 먼저 표시
        for (int i = 0; i <= maxIndex; i++) {
            prefixSum[C[i]] = 1;
        }

        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] += prefixSum[i - 1];
        }

        for (int i = 0; i < A.length; i++) {
            if (prefixSum[B[i]] - prefixSum[A[i] - 1] == 0) {
                return false;
            }
        }

        return true;
    }
}
