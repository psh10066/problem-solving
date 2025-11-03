package codility;

public class Codility_MinAvgTwoSlice {

    public int solution(int[] A) {
        int minAvgStart = 0;
        double minAvg = getMinAverage(A, 0);

        for (int i = 1; i < A.length - 1; i++) {
            double minAverage = getMinAverage(A, i);
            if (minAverage < minAvg) {
                minAvg = minAverage;
                minAvgStart = i;
            }
        }

        return minAvgStart;
    }

    private double getMinAverage(int[] A, int start) {
        double avg = (double) (A[start] + A[start + 1]) / 2;
        if (start + 2 < A.length) {
            double threeAvg = (double) (A[start] + A[start + 1] + A[start + 2]) / 3;
            if (threeAvg < avg) {
                avg = threeAvg;
            }
        }
        return avg;
    }
}
