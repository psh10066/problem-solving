package programmers;

public class Programmers_140107 {
    public long solution(int k, int d) {
        long answer = 0;

        for (int x = 0; x <= d; x = x + k) {
            int maxY = (int) Math.sqrt(Math.pow(d, 2) - Math.pow(x, 2));
            answer += maxY / k + 1;
        }

        return answer;
    }
}
