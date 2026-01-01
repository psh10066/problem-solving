package programmers;

public class Programmers_178870 {
    public int[] solution(int[] sequence, int k) {

        int[] prefixSum = new int[sequence.length + 1];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + sequence[i - 1];
        }

        int left = 0;
        int right = 0;

        int[] answer = {0, Integer.MAX_VALUE};

        while (left < sequence.length && right < sequence.length) {
            int sub = prefixSum[right + 1] - prefixSum[left];

            if (sub < k) {
                right++;
                continue;
            }
            if (sub > k) {
                left++;
                continue;
            }
            if (right - left < answer[1] - answer[0]) {
                answer[0] = left;
                answer[1] = right;
            }
            right++;
            left++;
        }

        return answer;
    }
}
