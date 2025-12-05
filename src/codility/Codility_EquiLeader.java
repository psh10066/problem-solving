package codility;

public class Codility_EquiLeader {

    public int solution(int[] A) {

        int leader = findLeader(A);
        if (leader == -1) {
            return 0;
        }

        int[] leaderCounts = new int[A.length];
        leaderCounts[0] = (A[0] == leader) ? 1 : 0;
        for (int i = 1; i < A.length; i++) {
            leaderCounts[i] = leaderCounts[i - 1] + ((A[i] == leader) ? 1 : 0);
        }

        int equiLeaderCount = 0;
        int totalLeaderCount = leaderCounts[A.length - 1];
        for (int i = 0; i < A.length - 1; i++) {
            int leftCount = i + 1;

            if (leaderCounts[i] > leftCount / 2 &&
                totalLeaderCount - leaderCounts[i] > (A.length - leftCount) / 2) {
                equiLeaderCount++;
            }
        }

        return equiLeaderCount;
    }

    public int findLeader(int[] A) {
        int count = 0;
        int candidate = 0;
        for (int i = 0; i < A.length; i++) {
            if (count == 0) {
                candidate = A[i];
                count++;
            } else {
                if (A[i] == candidate) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        int candidateCount = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == candidate) {
                candidateCount++;
            }
        }

        if (candidateCount > A.length / 2) {
            return candidate;
        } else {
            return -1;
        }
    }
}
