package codility;

import java.util.HashSet;
import java.util.Set;

public class Codility_OddOccurrencesInArray {

    public int solution(int[] A) {
        Set<Integer> countSet = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            if (countSet.contains(A[i])) {
                countSet.remove(A[i]);
            } else {
                countSet.add(A[i]);
            }
        }

        return countSet.iterator().next();
    }
}
