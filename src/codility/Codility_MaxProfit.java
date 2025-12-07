package codility;

public class Codility_MaxProfit {

    public int solution(int[] A) {
        if (A.length < 1) {
            return 0;
        }

        int before = A[0];
        int profit = 0;

        for (int i = 1; i < A.length; i++) {
            if (A[i] < before) {
                before = A[i];
                continue;
            }

            profit = Math.max(profit, A[i] - before);
        }

        return profit;
    }
}
