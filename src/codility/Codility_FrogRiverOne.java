package codility;

public class Codility_FrogRiverOne {
    public int solution(int X, int[] A) {
        boolean[] positions = new boolean[X + 1];
        int coveredPositions = 0;

        for (int time = 0; time < A.length; time++) {
            int position = A[time];
            if (position <= X && !positions[position]) {
                positions[position] = true;
                coveredPositions++;
                if (coveredPositions == X) {
                    return time;
                }
            }
        }
        return -1;
    }
}
