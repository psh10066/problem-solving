package codility;

import java.util.Arrays;

public class Codility_Triangle {

    public int solution(int[] A) {
        if (A.length < 3) {
            return 0;
        }

        Arrays.sort(A);

        long beforeSum = (long) A[0] + A[1];
        for (int i = 2; i < A.length; i++) {
            if (beforeSum > A[i]) {
                return 1;
            }
            beforeSum = (long) A[i - 1] + A[i];
        }
        return 0;
    }
}
