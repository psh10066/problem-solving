package codility;

import java.util.Arrays;

public class Codility_NumberOfDiscintersections {

    public int solution(int[] A) {
        int count = 0;

        long[] left = new long[A.length];
        long[] right = new long[A.length];

        for (int i = 0; i < A.length; i++) {
            left[i] = (long) i - A[i];
            right[i] = (long) i + A[i];
        }

        Arrays.sort(left);
        Arrays.sort(right);

        int leftIndex = 0;
        int rightIndex = 0;

        int intersections = 0;

        while (leftIndex < A.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                count += intersections;
                if (count > 10_000_000) {
                    return -1;
                }
                intersections++;
                leftIndex++;
            } else {
                intersections--;
                rightIndex++;
            }
        }

        return count;
    }
}
