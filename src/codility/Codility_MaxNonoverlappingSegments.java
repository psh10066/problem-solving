package codility;

public class Codility_MaxNonoverlappingSegments {

    public int solution(int[] A, int[] B) {

        int before = -1;
        int count = 0;

        for (int i = 0; i < A.length; i++) {
            if (before < A[i]) {
                count++;
                before = B[i];
            }
        }

        return count;
    }
}
