package codility;

public class Codility_Ladder {
    public int[] solution(int[] A, int[] B) {
        int L = A.length;

        long[] fibs = new long[L + 1];
        fibs[0] = 1;
        fibs[1] = 1;

        long bMax = (long) Math.pow(2, 30);
        for (int i = 2; i <= L; i++) {
            fibs[i] = (fibs[i - 1] + fibs[i - 2]) % bMax;
        }

        int[] result = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            result[i] = (int) (fibs[A[i]] % Math.pow(2, B[i]));
        }

        return result;
    }
}
