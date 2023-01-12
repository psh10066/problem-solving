package programmers;

public class Programmers_138477 {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int[] mj = new int[k];
        int minIndex = 0;
        int minValue = 0;

        for (int i = 0; i < score.length; i++) {
            if (i == 0) {
                mj[i] = minValue = score[i];
            } else {
                if (i < k) {
                    mj[i] = score[i];
                    if (score[i] < minValue) {
                        minIndex = i;
                        minValue = score[i];
                    }
                } else if (minValue < score[i]) {
                    mj[minIndex] = score[i];

                    minIndex = 0;
                    minValue = mj[0];
                    for (int j = 1; j < mj.length; j++) {
                        if (mj[j] < minValue) {
                            minIndex = j;
                            minValue = mj[j];
                        }
                    }
                }
            }
            answer[i] = minValue;
        }

        return answer;
    }
}
