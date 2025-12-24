package codility;

import java.util.Arrays;

public class Codility_CountTriangles {
    public int solution(int[] A) {
        if (A.length < 3) {
            return 0;
        }

        Arrays.sort(A);

        int count = 0;

        for (int i = A.length - 1; i >= 2; i--) {
            int max = A[i];

            int minStartIndex = 0;
            for (int j = i - 1; j >= 1; j--) {
                int mid = A[j];

                for (int k = minStartIndex; k < j; k++) {
                    int min = A[k];

                    if (min + mid > max) {
                        count += j - k;
                        break;
                    }
                    minStartIndex = k;
                }
            }
        }

        return count;
    }
}
