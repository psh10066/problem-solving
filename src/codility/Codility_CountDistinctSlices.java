package codility;

public class Codility_CountDistinctSlices {
    public int solution(int M, int[] A) {
        boolean[] check = new boolean[M + 1];

        int front = 0;
        int back = 0;

        int count = 0;

        while (back < A.length) {
            while (front < A.length && !check[A[front]]) {
                check[A[front]] = true;
                front++;
            }

            count += front - back;
            if (count >= 1_000_000_000) {
                return 1_000_000_000;
            }

            check[A[back++]] = false;
        }

        return count;
    }
}
