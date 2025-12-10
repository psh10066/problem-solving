package codility;

public class Codility_CountFactors {

    public int solution(int N) {

        int count = 0;
        long num = 1;

        while (num * num < N) {
            if (N % num == 0) {
                count += 2;
            }
            num++;
        }

        if (num * num == N) {
            count++;
        }
        return count;
    }
}
