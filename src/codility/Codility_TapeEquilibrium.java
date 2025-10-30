package codility;

public class Codility_TapeEquilibrium {
    public int solution(int[] A) {
        // N == A.length
        // P : 중간에 자르는 값.

        int totalSum = 0;
        for (int num : A) {
            totalSum += num;
        }

        int minDiff = Integer.MAX_VALUE;
        int leftSum = 0;
        for (int P = 1; P < A.length; P++) {
            leftSum += A[P - 1];
            int rightSum = totalSum - leftSum;
            int currentDiff = Math.abs(leftSum - rightSum);
            minDiff = Math.min(minDiff, currentDiff);
        }
        return minDiff;
    }
}
