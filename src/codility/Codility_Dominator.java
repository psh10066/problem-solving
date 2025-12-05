package codility;

import java.util.HashMap;
import java.util.Map;

public class Codility_Dominator {

    public int solution(int[] A) {

        Map<Integer, Integer> countMap = new HashMap<>();
        int dominatorCount = A.length / 2;

        for (int i = 0; i < A.length; i++) {
            int key = A[i];
            int count = countMap.getOrDefault(key, 0) + 1;

            if (count > dominatorCount) {
                return i;
            }

            countMap.put(key, count);
        }

        return -1;
    }
}
