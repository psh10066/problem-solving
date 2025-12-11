package codility;

public class Codility_MinPerimeterRectangle {

    public int solution(int N) {
        int A = (int) Math.sqrt(N);
        while (true) {
            if (N % A == 0) {
                int B = N / A;
                return 2 * (A + B);
            }
            A--;
        }
    }
}
