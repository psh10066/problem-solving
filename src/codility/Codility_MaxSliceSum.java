package codility;

public class Codility_MaxSliceSum {

    public int solution(int[] A) {

        int currentMax = A[0];
        int max = A[0];

        for (int i = 1; i < A.length; i++) {
            currentMax = Math.max(currentMax + A[i], A[i]);
            max = Math.max(max, currentMax);
        }

        return max;
    }
}
