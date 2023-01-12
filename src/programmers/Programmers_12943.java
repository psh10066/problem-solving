package programmers;

public class Programmers_12943 {
    public int solution(int num) {
        if (num == 1) return 0;

        long numL = num;

        for (int i = 1; i <= 500; i++) {
            numL = numL % 2 == 0 ? numL / 2 : numL * 3 + 1;
            if (numL == 1) return i;
        }

        return -1;
    }
}
