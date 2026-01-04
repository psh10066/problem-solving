package programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Programmers_172927 {
    class Five implements Comparable<Five> {
        int diaCount;
        int ironCount;
        int stoneCount;

        public Five() {
        }

        public Five(int diaCount, int ironCount, int stoneCount) {
            this.diaCount = diaCount;
            this.ironCount = ironCount;
            this.stoneCount = stoneCount;
        }

        public int getTotalCount() {
            return diaCount + ironCount + stoneCount;
        }

        @Override
        public int compareTo(Five o) {
            if (diaCount != o.diaCount) return diaCount - o.diaCount;
            if (ironCount != o.ironCount) return ironCount - o.ironCount;
            return stoneCount - o.stoneCount;
        }
    }

    public int solution(int[] picks, String[] minerals) {
        int diaPickax = picks[0];
        int ironPickax = picks[1];
        int stonePickax = picks[2];
        int totalPickax = diaPickax + ironPickax + stonePickax;
        int totalMinerals = Math.min(minerals.length, totalPickax * 5);

        List<Five> fiveList = new ArrayList<>();
        Five currentFive = new Five();
        for (int i = 0; i < totalMinerals; i++) {
            if (currentFive.getTotalCount() == 5) {
                fiveList.add(currentFive);
                currentFive = new Five();
            }
            switch (minerals[i]) {
                case "diamond":
                    currentFive.diaCount++;
                    break;
                case "iron":
                    currentFive.ironCount++;
                    break;
                case "stone":
                    currentFive.stoneCount++;
                    break;
            }
        }
        fiveList.add(currentFive);

        fiveList.sort(Comparator.reverseOrder());

        int answer = 0;

        for (Five five : fiveList) {
            if (diaPickax > 0) {
                answer += five.getTotalCount();
                diaPickax--;
                continue;
            }
            if (ironPickax > 0) {
                answer += five.diaCount * 5 + five.ironCount + five.stoneCount;
                ironPickax--;
                continue;
            }
            if (stonePickax > 0) {
                answer += five.diaCount * 25 + five.ironCount * 5 + five.stoneCount;
                stonePickax--;
                continue;
            }
            break;
        }

        return answer;
    }
}
