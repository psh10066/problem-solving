package codility;

public class Codility_NumberSolitaire {
    public int solution(int[] A) {

        int[] arr = new int[A.length];
        arr[0] = A[0];

        for (int i = 1; i < A.length; i++) {
            arr[i] = Integer.MIN_VALUE;
            for (int j = Math.max(0, i - 6); j < i; j++) {
                arr[i] = Math.max(arr[i], arr[j]);
            }
            arr[i] += A[i];
        }

        return arr[A.length - 1];
    }
}
