package programmers;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Programmers_138476 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i : tangerine) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }

        List<Integer> list = hashMap.values().stream()
            .sorted(Comparator.comparing(Integer::intValue).reversed())
            .collect(Collectors.toList());

        for (Integer i : list) {
            answer++;
            k -= i;
            if (k <= 0) break;
        }

        return answer;
    }
}
