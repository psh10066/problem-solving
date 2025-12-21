package codility;

public class Codility_MinMaxDivision {
    public int solution(int K, int M, int[] A) {
        int N = A.length;

        int low = 0;
        int high = 0;

        for (int i = 0; i < N; i++) {
            low = Math.max(A[i], low);
            high += A[i];
        }

        int result = high;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canDivide(mid, K, A)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    public boolean canDivide(int maxSum, int K, int[] A) {
        int sum = 0;
        int count = 1;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum > maxSum) {
                sum = A[i];
                if (++count > K) {
                    return false;
                }
            }
        }
        return true;
    }
}
