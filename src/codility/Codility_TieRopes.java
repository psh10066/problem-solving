package codility;

public class Codility_TieRopes {
    public int solution(int K, int[] A) {
        int sum = 0;
        int count = 0;

        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum >= K) {
                count++;
                sum = 0;
            }
        }

        return count;
    }
}
