package codility;

public class Codility_Distinct {
    public int solution(int[] A) {
        return (int) java.util.Arrays.stream(A).distinct().count();
    }
}
