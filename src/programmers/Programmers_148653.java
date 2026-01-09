package programmers;

public class Programmers_148653 {
    public int solution(int storey) {
        int count = 0;
        while (storey > 0) {
            int value = storey % 10;
            if (value < 5) {
                count += value;
            } else if (value > 5) {
                count += 10 - value;
                storey += 10;
            } else {
                count += 5;
                if (storey % 100 / 10 >= 5) {
                    storey += 10;
                }
            }
            storey /= 10;
        }
        return count;
    }
}
