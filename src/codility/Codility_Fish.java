package codility;

import java.util.Stack;

public class Codility_Fish {

    public int solution(int[] A, int[] B) {
        Stack<Integer> downstreamFish = new Stack<>();

        int survivingUpstreamFishCount = 0;

        for (int i = 0; i < A.length; i++) {
            if (B[i] == 1) {
                downstreamFish.push(A[i]);
            } else {
                while (!downstreamFish.isEmpty()) {
                    if (downstreamFish.peek() > A[i]) {
                        // 내려오는 물고기가 이긴 경우
                        break;
                    } else {
                        // 내려오는 물고기가 잡아먹힌 경우
                        downstreamFish.pop();
                    }
                }
                // 내려오는 물고기가 없거나 다 먹은 경우
                if (downstreamFish.isEmpty()) {
                    survivingUpstreamFishCount++;
                }
            }
        }

        return survivingUpstreamFishCount + downstreamFish.size();
    }
}
