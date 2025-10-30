package codility;

import java.util.HashSet;
import java.util.Set;

public class Codility_MissingInteger {
    public int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int value : A) {
            set.add(value);
        }
        for (int i = 1; i <= 100_000; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 100_001;
    }
}
