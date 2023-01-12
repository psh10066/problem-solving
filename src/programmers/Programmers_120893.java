package programmers;

public class Programmers_120893 {
    public String solution(String my_string) {
        String answer = "";
        int caseDistance = 'a' - 'A';

        for (char c : my_string.toCharArray()) {
            answer += (char) (c <= 'Z' ? c + caseDistance : c - caseDistance);
        }

        return answer;
    }
}
