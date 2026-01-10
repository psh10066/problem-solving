package programmers;

import java.util.HashMap;
import java.util.Map;

public class Programmers_131127 {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> countMap = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            String fruit = discount[i];
            int count = 0;
            if (countMap.containsKey(fruit)) {
                count = countMap.get(fruit);
            }
            countMap.put(fruit, count + 1);
        }

        int answer = 0;

        for (int i = 0; i < discount.length - 9; i++) {
            boolean ok = true;
            for (int j = 0; j < want.length; j++) {
                if (!countMap.containsKey(want[j]) || countMap.get(want[j]) != number[j]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                System.out.println(i);
                answer++;
            }

            countMap.put(discount[i], countMap.get(discount[i]) - 1);

            if (i + 10 < discount.length) {
                String fruit = discount[i + 10];
                int count = 0;
                if (countMap.containsKey(fruit)) {
                    count = countMap.get(fruit);
                }
                countMap.put(fruit, count + 1);
            }
        }

        return answer;
    }
}
