package codility;

public class Codility_MaxDoubleSliceSum {

    public int solution(int[] A) {

        int[] left = new int[A.length];
        int[] right = new int[A.length];

        for (int i = 1; i < A.length; i++) {
            left[i] = Math.max(left[i - 1] + A[i], 0);
        }

        for (int i = A.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1] + A[i], 0);
        }

        int result = 0;
        for (int i = 1; i < A.length - 1; i++) {
            result = Math.max(result, left[i - 1] + right[i + 1]);
        }

        return result;
    }
}
