package programmers;

public class Programmers_140108 {
    public int solution(String s) {
        int answer = 0;
        int xCount = 0;
        int yCount = 0;
        char x = 0;
        for (int i = 0; i < s.length(); i++) {
            if (xCount == 0) {
                x = s.charAt(i);
                xCount++;
            } else {
                if (x == s.charAt(i)) {
                    xCount++;
                } else {
                    yCount++;
                }
                if (xCount == yCount) {
                    answer++;
                    xCount = yCount = 0;
                    continue;
                }
            }
            if (i + 1 == s.length()) {
                return answer + 1;
            }
        }
        return answer;
    }
}
