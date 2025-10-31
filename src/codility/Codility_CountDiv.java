package codility;

public class Codility_CountDiv {
    public int solution(int A, int B, int K) {
        if (B == 0) {
            return 1;
        }

        int divisibleCountB = B / K;
        if (A == 0) {
            return divisibleCountB + 1;
        } else {
            return divisibleCountB - (A - 1) / K;
        }
    }
}
