package codility;

import java.util.ArrayList;
import java.util.List;

public class Codility_CountSemiprimes {

    public int[] solution(int N, int[] P, int[] Q) {
        boolean[] checked = new boolean[N + 1];
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= N; i++) {
            if (checked[i]) {
                continue;
            }

            primes.add(i);
            for (int j = i; j <= N; j += i) {
                checked[j] = true;
            }
        }

        boolean[] isSemiprime = new boolean[N + 1];

        for (int i = 0; i < primes.size(); i++) {
            int p1 = primes.get(i);
            for (int j = i; j < primes.size(); j++) {
                int p2 = primes.get(j);
                long multi = (long) p1 * p2;
                if (multi > N) {
                    break;
                }
                isSemiprime[(int) multi] = true;
            }
        }

        int[] semiprimeCount = new int[N + 1];
        for (int i = 4; i <= N; i++) {
            if (isSemiprime[i]) {
                semiprimeCount[i] = semiprimeCount[i - 1] + 1;
            } else {
                semiprimeCount[i] = semiprimeCount[i - 1];
            }
        }

        int[] result = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            result[i] = semiprimeCount[Q[i]] - semiprimeCount[P[i] - 1];
        }

        return result;
    }
}
