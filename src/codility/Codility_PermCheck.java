package codility;

public class Codility_PermCheck {
    public int solution(int[] A) {
        boolean[] checked = new boolean[A.length + 1];
        for (int num : A) {
            if (num > A.length || checked[num]) {
                return 0;
            }
            checked[num] = true;
        }
        return 1;
    }
}
