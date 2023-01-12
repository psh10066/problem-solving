package programmers;

public class Programmers_142086 {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        java.util.HashMap<Character, Integer> charMap = new java.util.HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            answer[i] = charMap.containsKey(c) ? i - charMap.get(c) : -1;
            charMap.put(c, i);
        }
        return answer;
    }
}
