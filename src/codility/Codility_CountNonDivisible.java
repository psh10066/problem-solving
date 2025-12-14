package codility;

public class Codility_CountNonDivisible {

    public int[] solution(int[] A) {
        int N = A.length;

        int maxValue = 0;
        for (int i = 0; i < N; i++) {
            maxValue = Math.max(maxValue, A[i]);
        }

        int[] count = new int[maxValue + 1];
        for (int i = 0; i < N; i++) {
            count[A[i]]++;
        }

        int[] divisorCount = new int[maxValue + 1];
        for (int i = 1; i < count.length; i++) {
            if (count[i] == 0) {
                continue;
            }

            for (int j = i; j < count.length; j += i) {
                divisorCount[j] += count[i];
            }
        }

        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = N - divisorCount[A[i]];
        }
        return result;
    }
}
