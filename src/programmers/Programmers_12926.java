package programmers;

public class Programmers_12926 {
    public String solution(String s, int n) {
        String answer = "";

        for (char c : s.toCharArray()) {
            if (c != ' ') {
                boolean isUpper = c <= 'Z';
                c += n;
                if ((isUpper && c > 'Z') || (!isUpper && c > 'z')) {
                    c -= 'Z' - 'A' + 1;
                }
            }
            answer += c;
        }

        return answer;
    }
}
