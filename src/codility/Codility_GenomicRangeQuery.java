package codility;

public class Codility_GenomicRangeQuery {
    int[] countA;
    int[] countC;
    int[] countG;

    public int[] solution(String S, int[] P, int[] Q) {
        countA = new int[S.length()];
        countC = new int[S.length()];
        countG = new int[S.length()];

        for (int i = 0; i < S.length(); i++) {
            if (i > 0) {
                countA[i] = countA[i - 1];
                countC[i] = countC[i - 1];
                countG[i] = countG[i - 1];
            }
            switch (S.charAt(i)) {
                case 'A' -> countA[i]++;
                case 'C' -> countC[i]++;
                case 'G' -> countG[i]++;
            }
        }

        int[] result = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            result[i] = getResult(P[i], Q[i]);
        }
        return result;
    }

    private int getResult(int from, int to) {
        if (from == 0) {
            if (countA[to] > 0) return 1;
            if (countC[to] > 0) return 2;
            if (countG[to] > 0) return 3;
            return 4;
        } else {
            if (countA[to] - countA[from - 1] > 0) return 1;
            if (countC[to] - countC[from - 1] > 0) return 2;
            if (countG[to] - countG[from - 1] > 0) return 3;
            return 4;
        }
    }
}
