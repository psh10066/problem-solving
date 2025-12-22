package codility;

public class Codility_AbsDistinct {
    public int solution(int[] A) {
        int left = 0;
        int right = A.length - 1;

        long lastAbs = -1;
        int count = 0;
        while (left <= right) {
            long leftAbs = Math.abs((long) A[left]);
            long rightAbs = Math.abs((long) A[right]);

            if (leftAbs == lastAbs) {
                left++;
                continue;
            }
            if (rightAbs == lastAbs) {
                right--;
                continue;
            }

            count++;
            if (leftAbs >= rightAbs) {
                left++;
            }
            if (leftAbs <= rightAbs) {
                right--;
            }
        }

        return count;
    }
}
