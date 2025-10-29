package codility;

public class Codility_CyclicRotation {
    public int[] solution(int[] A, int K) {
        if (A.length == 0) {
            return A;
        }
        int times = K % A.length;
        int[] rotatedArray = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            rotatedArray[(i + times) % A.length] = A[i];
        }
        return rotatedArray;
    }
}
