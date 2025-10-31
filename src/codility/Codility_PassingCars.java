package codility;

public class Codility_PassingCars {
    public int solution(int[] A) {
        long totalCount = 0;
        int westCount = 0;

        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] == 0) {
                totalCount += westCount;
                // 지나가는 자동차의 수가 1,000,000,000 초괴이면 -1 return
                if (totalCount > 1_000_000_000) {
                    return -1;
                }
            } else {
                westCount++;
            }
        }

        return (int) totalCount;
    }
}
