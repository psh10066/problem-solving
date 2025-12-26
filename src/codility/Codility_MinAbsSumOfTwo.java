package codility;

import java.util.Arrays;

public class Codility_MinAbsSumOfTwo {
    public int solution(int[] A) {
        int left = 0;
        int right = A.length - 1;

        Arrays.sort(A);

        int min = Integer.MAX_VALUE;
        while (left <= right) {
            int value = A[left] + A[right];
            min = Math.min(min, Math.abs(value));

            if (value < 0) {
                left++;
            } else {
                right--;
            }
        }

        return min;
    }
}
